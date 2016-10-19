package practica1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc {

    Scanner lector = new Scanner(System.in);
    private ArrayList<Ficha> fichas = new ArrayList();
    private ArrayList<Jugador> nomJugador = new ArrayList();
    private int jugador;
    private int turno;
    private Jugada jug = new Jugada();
    private ArrayDeque<Ficha> fichasTablero = new ArrayDeque();

    public Joc() {
        afegirFichas();
        crearJugadors();
        asignarFichas();
        jugadorInicial();
        turnos();
    }

    private void afegirFichas() {
        //Doble bucle de for per afegir les 28 fiches
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new Ficha(i, j));
            }

        }
    }

    private void crearJugadors() {
        //For per asignar els noms als jugadors
        String nom;
        for (int i = 0; i < 4; i++) {
            nomJugador.add(new Jugador("Jugador" + (i + 1)));
        }
    }

    private void asignarFichas() {
        //Metode per asignar les fiches
        while (fichas.size() != 0) {
            for (int j = 0; j < 4; j++) {
                Random fichaAleatoria = new Random();
                int aleatorio = fichaAleatoria.nextInt(fichas.size());
                nomJugador.get(j).añadirFicha(fichas.get(aleatorio));
                fichas.remove(aleatorio);
            }
        }
    }

    private int jugadorInicial() {
        //Recorre los diferentes jugadores mirando las fichas que tiene en conjunto con el metodo que tenemos en Jugador para ir mirando las fichas en el ArrayList
        //Del Jugador que le toca, si es el jugador lo muestra por pantalla y lo asigna a una variable para comenzar con el la partida.
        int contador=0;
        for (Jugador j : nomJugador) {

            if (j.getFichasJugador().contains(new Ficha(6, 6))) {
                jugador = contador;
                break;
            }
            contador++;
        }

//        ArrayList<Ficha> fichas = jug.getFichasJugador();
//        for (int i = 0; i < nomJugador.size(); i++) {
//            if (nomJugador.get(i).trobarFichaIncial()) {
//                jugador = i;
//                break;
//            }
//        }
        System.out.println(jugador);
        return jugador;

    }

    public void turnos() {
        turno = jugador;

    }
}
