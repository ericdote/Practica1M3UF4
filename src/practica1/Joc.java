package practica1;

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

    public Joc() {
        afegirFichas();
        crearJugadors();
        asignarFichas();
        jugadorInicial();
        turnos();
    }

    public void afegirFichas() {
        //Doble bucle de for per afegir les 28 fiches
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new Ficha(i, j));
            }

        }
    }

    public void crearJugadors() {
        //For per asignar els noms als jugadors
        String nom;
        for (int i = 0; i < 4; i++) {
            nomJugador.add(new Jugador("Jugador" + (i+1)));
        }
    }

    public void asignarFichas() {
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

    public void jugadorInicial() {
        //Recorre los diferentes jugadores mirando las fichas que tiene en conjunto con el metodo que tenemos en Jugador para ir mirando las fichas en el ArrayList
        //Del Jugador que le toca, si es el jugador lo muestra por pantalla y lo asigna a una variable para comenzar con el la partida.
        for (int i = 0; i < nomJugador.size(); i++) {
            if (nomJugador.get(i).trobarFichaIncial()) {
                jugador = i;
                break;
            }
        }
    }

    public void turnos() {
        turno = jugador;
    }
}
