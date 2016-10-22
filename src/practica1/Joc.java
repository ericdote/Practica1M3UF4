package practica1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc {

    Scanner lector = new Scanner(System.in);
    private ArrayList<Ficha> fichas;
    public ArrayList<Jugador> nomJugador;
    private ArrayDeque<Ficha> fichasTablero;
    public int jugadorTorn;
    private String nom;
    private int pasar, jugador, guanyador;
    private int contador, contadorInicial;
    
    /**
     * Aqui ejecutamos en orden todas las tareas que se deben realizar durante todo el juego
     */
    public Joc() {        
        fichasTablero = new ArrayDeque();
        afegirFichas();
        crearJugadors();
        asignarFichas();
        for(Jugador j : nomJugador){
            System.out.println(j.toString());
        }
        jugadorTorn = 0;
        jugadorInicial();
        for(Jugador j : nomJugador){
            System.out.println(j.toString());
        }
        actualitzarJoc();
            System.out.println("And the WINNER IIIIIIIIIIIIIIS " + guanyador);
        
    }
    /**
     * Crea las 28 fichas
     */
    private void afegirFichas() {
        fichas = new ArrayList();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new Ficha(i, j));
            }

        }

    }
    /**
     * Crea los 4 jugadores
     */
    private void crearJugadors() {
        nomJugador = new ArrayList();
        for (int i = 0; i < 4; i++) {
            nomJugador.add(new Jugador("Jugador" + (i + 1)));
        }
    }
    /**
     * Mitjançant un array de booleans controlem les fiches que han sigut assignades
     * D'aquesta forma anem afegint fiches amb un Random de forma aleatoria al arrayList de cada jugador les seves fiches
     */
    private void asignarFichas() {
        boolean[] utilitzades = new boolean[fichas.size()];
        int contador = 0;
        while (contador != fichas.size()) {
            for (int i = 0; i < nomJugador.size(); i++) {
                Random r = new Random();
                int ale = r.nextInt(fichas.size());
                while (utilitzades[(ale = r.nextInt(fichas.size()))]);
                nomJugador.get(i).getFichasJugador().add(fichas.get(ale));
                utilitzades[ale] = true;
                contador++;
            }
        }
    }
    /**
     * Aqui trobem el jugador inicial mitjançant un foreach recorrem tots els jugadors
     * Cada cop que passem per un jugador mirem totes els seves fitxes buscant quina te en els seus 2 atributis el 6,6
     * Un cop trobat afegeix la fitxa al ArrayList fichasTablero, on guardarem les fitxes jugades, i eliminem la fitxa del arraylist del usuari
     * Un cop fet aixo tornem el jugador que toca + 1 per donar pas al següent.
     * @return 
     */
    private int jugadorInicial() {
        jugador = 0;
        int fitxa = 0;
        contadorInicial = 0;

        for (Jugador j : nomJugador) {
            for (int i = 0; i < 7; i++) {
                if (j.getFichasJugador().get(i).getDreta() == 6
                        && j.getFichasJugador().get(i).getEsquerra() == 6) {
                    jugador = contadorInicial;
                    fitxa = i;
                    System.out.println("primer = " + jugador + " fitxa = " + fitxa);
                    fichasTablero.addFirst(j.getFichasJugador().get(fitxa));
                    j.getFichasJugador().remove(fitxa);
                    break;
                }
            }
            contadorInicial++;
        }
        return (jugador + 1);
    }
    /**
     * Per actualitzar el joc seguim un procediment el cual esta basat de 3 pautes
     * Si els 4 jugadors han passat es fa un bucle per fer comprovacions amb els 4 jugadors
     * es busca el guanyador, en cas de que un jugador tingui menys punts que altre, aquest guanyara
     * si hi ha empat, es mirará la quantitat de fitxes. En cas de que el jugador simplement s'hagi quedat a 0 fitxes, guanya
     * Si cap a passat es calcula el torn.
     * @return 
     */
    public int actualitzarJoc() {
        boolean inicial = true;
        if (pasar == 4) {
            for (int i = 0; i < 4; i++) {
                if (inicial){
                    guanyador = i;
                    inicial = false;
                }                    
                if (calculaGuanyador(i) < calculaGuanyador(guanyador)) {
                    guanyador = i;
                    finalitzaJoc();
                } else if (calculaGuanyador(i) == calculaGuanyador(guanyador)
                        && nomJugador.get(i).getFichasJugador().size() < nomJugador.get(guanyador).getFichasJugador().size()) {
                    guanyador = i;
                    finalitzaJoc();
                }
            }
        } else if (nomJugador.get(jugadorTorn).fichasJugador.size() == 0) {
            guanyador = jugadorTorn;
            finalitzaJoc();

        } else {
            jugadorTorn = (++jugadorTorn) % 4;
        }
        return guanyador;
    }

    public int calculaGuanyador(int participant) {
        int puntuacio = 0;
        for (int j = 0; j < nomJugador.get(participant).fichasJugador.size(); j++) {
            puntuacio += nomJugador.get(participant).fichasJugador.get(j).getDreta();
            puntuacio += nomJugador.get(participant).fichasJugador.get(j).getEsquerra();
        }
        return puntuacio;
    }

    public void finalitzaJoc() {
        System.exit(0);
    }
}
