package practica1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc {

    Scanner lector = new Scanner(System.in);
    private ArrayList<Ficha> fichas;
    public ArrayList<Jugador> nomJugador;
    private int turno;
    private ArrayDeque<Ficha> fichasTablero;
    public int jugadorTorn;
    private String nom;
    private int pasar, jugador;
    private int[] ganador;
    private int contador, contadorInicial;

    public Joc() {
        fichasTablero = new ArrayDeque();
        afegirFichas();
        crearJugadors();
        asignarFichas();
        jugadorTorn = 0;
        jugadorInicial();
        //actualitzarJoc();
    }

    private void afegirFichas() {
        fichas = new ArrayList();

        //Doble bucle de for per afegir les 28 fiches
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new Ficha(i, j));
            }

        }

    }

    private void crearJugadors() {
        nomJugador = new ArrayList();
        for (int i = 0; i < 4; i++) {
            nomJugador.add(new Jugador("Jugador" + (i + 1)));
        }
    }

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

//    public void actualitzarJoc() {
//        int guanyador = -1;
//        if (pasar == 4) {
//            calculaGuanyador();
//            for (Jugador j :) {
//                if (ganador[i] < ganador[guanyador]) {
//                    guanyador = i;
//              finalitzaJoc();
//                } else if (ganador[i] == ganador[guanyador]
//                        && llistaJugadors[i].fitxesJugador.size() < llistaJugadors[guanyador].fitxesJugador.size()) {
//                    guanyador = i;
//                    finalitzaJoc();
//                }
//            }
//        } else if (llistaJugadors[torn].fitxesJugador.size() == 0) {
//
//            guanyador = torn;
//              finalitzaJoc();
//
//        } else {
//            torn = (++torn) % 4;
//        }
//        return guanyador;
//    }
    public int calculaGuanyador() {
        int valor = 0;
        ganador = new int[4];
        contador = 0;
        if (pasar == 4) {
            for (Jugador j : nomJugador) {
                for (Ficha f : j.getFichasJugador()) {
                    valor += f.getDreta();
                    valor += f.getEsquerra();
                    ganador[contador] = valor;
                }
                contador++;
            }
        }

        return 0;
    }

    public void finalitzaJoc() {
        System.exit(0);
    }
}
