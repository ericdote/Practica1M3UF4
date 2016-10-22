/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Deque;
import practica1.Joc;

/**
 * 
 * @author ALUMNEDAM
 */
public class Jugada {

    private Joc joc;

    public Jugada() {
        this.joc = joc;
    }

    /**
     * Calcula els tipus de fitxa que té un jugador
     * 0 = la fitxa no es pot colocar, 1 = la fitxa es pot colocar, 2 = la fitxa es doble
     * @return un array de bytes amb els tipus de fitxes que té el jugador.
     */
    public byte[] possibleFitxa() {
        byte[] possibles = new byte[joc.nomJugador[joc.turno].fichasJugador.size()];
        for (int i = 0; i < possibles.length; i++) {
            possibles[i] = determinarTipusFitxa(i);

        }
        return possibles;
    }

    /**
     * Realitza una tirada, li passem l'array amb les possibles tirades, i comprova
     * si pot colocar fitxes dobles, o si no té tirada possible, si no demana una
     * posició per a una fitxa i la posicio del tauler on es colocara.
     * @param possibles
     */
    public void realitzarTirada(byte[] possibles) {
        boolean fitxaUnica = false;
        byte contDobles = 0;

        for (int i = 0; i < possibles.length; i++) {
            if (possibles[i] == 1 && fitxaUnica == false) {
                fitxaUnica = true;
            } else if (possibles[i] == 2) {
                contDobles++;
                if (fitxaUnica == false) {
                    fitxaUnica = true;
                }
            }
        }
        if (contDobles == 2) {
            colocarDobles(possibles);
            joc.passades = 0;
        } else if (fitxaUnica == false) {
            joc.passades++;
        } else {
            int posicio = 0;
            char posicioTauler = 'L';
            colocarFitxa(posicio,posicioTauler);
            joc.passades = 0;
        }
    }

    /**
     * Determina el tipus de fitxa d'un jugador,
     * 0 = no colocable, 1 = colocable, 2 = colocable i doble
     * @param i index de la fitxa
     * @return 
     */
    public byte determinarTipusFitxa(int i) {
        byte cont = 0;
        if (joc.llistaJugadors[joc.getTorn()].fitxesJugador.get(i).getNum1() == joc.fitxesTauler.getFirst().num1
                || joc.llistaJugadors[joc.torn].fitxesJugador.get(i).getNum2() == joc.fitxesTauler.getFirst().num1
                || joc.llistaJugadors[joc.torn].fitxesJugador.get(i).getNum1() == joc.fitxesTauler.getLast().num2
                || joc.llistaJugadors[joc.torn].fitxesJugador.get(i).getNum2() == joc.fitxesTauler.getLast().num2) {

            if (joc.llistaJugadors[joc.torn].fitxesJugador.get(i).getNum1() == joc.llistaJugadors[joc.torn].fitxesJugador.get(i).getNum2()) {
                cont = 2;
            } else {
                cont = 1;
            }
        } else {
            cont = 0;
        }
        return cont;
    }

    //CAMBIAR TIRADA POSSIBLE
    /**
     * Escull una fitxa per colocarla a la posicio desitjada del tauler
     * @param posicio 
     * @param posicioTauler char amb els valors L (left) o R (right) per
     * colocar a l'esquerra o a la dreta la fitxa desitjada.
     */
    public void colocarFitxa(int posicio, char posicioTauler) {
        if (posicioTauler == 'L') {
            joc.fitxesTauler.addFirst(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.llistaJugadors[joc.torn].fitxesJugador.remove(posicio);
        } else if (posicioTauler == 'R') {
            joc.fitxesTauler.addLast(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.llistaJugadors[joc.torn].fitxesJugador.remove(posicio);
        }

    }

    /**
     * Se li pasa una posicio i calcula tots els casos possibles per introduir aquesta.
     * @param posicio int amb la posicio de la fitxa a la llista dels jugadors.
     */
    public void colocarFitxaIA(int posicio) {
        if (joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio).getNum2() == joc.fitxesTauler.getFirst().num1) {

            joc.fitxesTauler.addFirst(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.llistaJugadors[joc.torn].fitxesJugador.remove(posicio);
        } else if (joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio).getNum1() == joc.fitxesTauler.getLast().num2) {

            joc.fitxesTauler.addLast(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.llistaJugadors[joc.torn].fitxesJugador.remove(posicio);
        } else if (joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio).getNum1() == joc.fitxesTauler.getFirst().num1) {

            rotarFitxa(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.fitxesTauler.addFirst(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.llistaJugadors[joc.torn].fitxesJugador.remove(posicio);
        } else if (joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio).getNum2() == joc.fitxesTauler.getLast().num2) {

            rotarFitxa(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.fitxesTauler.addLast(joc.llistaJugadors[joc.torn].fitxesJugador.get(posicio));
            joc.llistaJugadors[joc.torn].fitxesJugador.remove(posicio);
        }

    }
    /**
     * "Rota" la fitxa en cas de que estigui amb la orientacio equivocada
     * @param fitxa fitxa del jugador
     */
    public void rotarFitxa(Fitxa fitxa) {
        int aux = fitxa.getNum2();
        fitxa.setNum2(fitxa.getNum1());
        fitxa.setNum1(aux);
    }

    /**
     * Coloca dos dobles en cas de que el jguador els tingui.
     * @param possibles array amb el tipus de fitxa qu té el jugador.
     */
    public void colocarDobles(byte[] possibles) {
        int fitxa1 = -1;
        int fitxa2 = -1;

        for (int i = 0; i < possibles.length; i++) {
            if (possibles[i] == 2 && fitxa1 == -1) {
                fitxa1 = i;
            } else if (possibles[i] == 2 && fitxa1 != -1) {
                fitxa2 = i;
            }
        }
        if (fitxa1 != -1 && fitxa2 != -1) {
            if (joc.llistaJugadors[joc.torn].fitxesJugador.get(fitxa1).getNum2()
                    == joc.fitxesTauler.getFirst().getNum1()) {
                joc.fitxesTauler.addFirst(joc.llistaJugadors[joc.torn].fitxesJugador.get(fitxa1));
                joc.fitxesTauler.addLast(joc.llistaJugadors[joc.torn].fitxesJugador.get(fitxa2));
                joc.llistaJugadors[joc.torn].fitxesJugador.remove(fitxa1);
                joc.llistaJugadors[joc.torn].fitxesJugador.remove(fitxa2);

            } else {
                joc.fitxesTauler.addFirst(joc.llistaJugadors[joc.torn].fitxesJugador.get(fitxa2));
                joc.fitxesTauler.addLast(joc.llistaJugadors[joc.torn].fitxesJugador.get(fitxa1));
                joc.llistaJugadors[joc.torn].fitxesJugador.remove(fitxa1);
                joc.llistaJugadors[joc.torn].fitxesJugador.remove(fitxa2);
            }
        }
    }

}