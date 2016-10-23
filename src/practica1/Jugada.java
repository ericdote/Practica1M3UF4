package practica1;

import java.util.Deque;
import practica1.Joc;

public class Jugada {

    private Joc joc;

    public Jugada() {
        this.joc = joc;
    }

    /**
     * En este metodo buscamos en las fichas del jugador actual fichas que se
     * puedan colocar en el tablero. Una vez encontrada alguna situamos su
     * posicion (L o R) y ponemos un booleano en true. Enviamos al metodo donde
     * colocamos las fichas la posicion donde ira la ficha (L o R) y la posicion
     * donde se encuentra del ArrayList(por eso el contador) y hacemos un break.
     * Por ultimo llamamos al metodo Pasado y le enviamos el booleano para
     * realizar la comprovacion de si se ha pasado o no turno.
     */
    public void realizarJugada() {
        int contador = 0;
        char posicion = 'L';
        boolean colocado = false;
        for (Ficha f : joc.nomJugador.get(joc.jugadorTorn).fichasJugador) {
            if (f.getDreta() == joc.fichasTablero.getFirst().getEsquerra()) {
                posicion = 'L';
                colocado = true;
                colocarFichaTablero(contador, posicion);
                break;
            } else if (f.getEsquerra() == joc.fichasTablero.getFirst().getEsquerra()) {
                posicion = 'L';
                colocado = true;
                rotarFicha(f);
                colocarFichaTablero(contador, posicion);
                break;
            } else if (f.getEsquerra() == joc.fichasTablero.getFirst().getDreta()) {
                posicion = 'R';
                colocado = true;
                colocarFichaTablero(contador, posicion);
                break;
            } else if (f.getDreta() == joc.fichasTablero.getFirst().getDreta()) {
                posicion = 'R';
                rotarFicha(f);
                colocado = true;
                colocarFichaTablero(contador, posicion);
                break;
            }
            contador++;
        }
        pasado(colocado);

    }

    /**
     * Li arriben al metode la posicio de la fitxa i la posicio que tindra
     * aquesta al tauler Es comproba on volem colocar-la, si a la dreta o a la
     * esquerra i s'afegeix, seguir de eliminarla del arraylist de fitxes del
     * jugador
     *
     * @param posicion
     * @param posicionTablero
     */
    public void colocarFichaTablero(int posicion, char posicionTablero) {
        if (posicionTablero == 'L') {
            joc.fichasTablero.addFirst(joc.nomJugador.get(joc.jugadorTorn).fichasJugador.get(posicion));
            joc.nomJugador.get(joc.jugadorTorn).fichasJugador.remove(posicion);
        } else if (posicionTablero == 'R') {
            joc.fichasTablero.addFirst(joc.nomJugador.get(joc.jugadorTorn).fichasJugador.get(posicion));
            joc.nomJugador.get(joc.jugadorTorn).fichasJugador.remove(posicion);
        }
    }

    /**
     * Aquest metode serveix per si hem de rotar la Fitxa en cas de que estigui
     * del reves. Aixi la podreme colocar del reves al tauler.
     *
     * @param ficha
     */
    public void rotarFicha(Ficha ficha) {
        int aux = ficha.getEsquerra();
        ficha.setEsquerra(ficha.getDreta());
        ficha.setDreta(aux);
    }

    /**
     * Le llega comprueba del metodo realizarJugada, donde comprobamos si se ha
     * pasado turno o no. En caso de haber pasado turno se suma +1, si no, se
     * devuelve a 0 ya que no se ha vuelto a pasar.
     *
     * @param comprueba
     */
    public void pasado(boolean comprueba) {
        if (comprueba) {
            joc.pasar = 0;
        } else {
            joc.pasar++;
        }
    }

}
