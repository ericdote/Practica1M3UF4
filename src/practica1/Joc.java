package practica1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc {

    Scanner lector = new Scanner(System.in);
    private ArrayList<Ficha> fichas;
    private ArrayList<Jugador> nomJugador;
    private int turno;
    private ArrayDeque<Ficha> fichasTablero;
    public int jugadorTorn;
    private Jugador jug;
    private String nom;
    private int pasar;
    private String guanyador;

    public Joc() {
        fichasTablero = new ArrayDeque();
        afegirFichas();
        crearJugadors();
        asignarFichas();
        jugadorTorn = 0;
        jugadorInicial();
        actualitzarJoc();
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
        //For per asignar els noms als nomJugador
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
        for (Jugador j : nomJugador) {
            if (j.getFichasJugador().contains(fichas.get(fichas.size() - 1))) {
                jugadorTorn = nomJugador.indexOf(j);
                nom = nomJugador.toString();
                break;
            }
        }
        System.out.println(jugadorTorn);
        System.out.println(nom);
        return jugadorTorn;
    }

    public void actualitzarJoc() {
        jug = new Jugador(nom);
        if (jug.getFichasJugador().equals(0)) {
            guanyador = jug.getNom(); //Esto habria que comprobarlo, ya que en principio gana el jugador que se queda sin fichas
                                      //Per falta por saber si es correcto tener guardado al ganador por su nombre en vez de id int.
            finalitzaJoc();
        } else if (pasar == 4) {
            finalitzaJoc();
        } else {
            jugadorTorn = (jugadorTorn + 1) % 4;
        }
    }

    public int calculaGuanyador() {

        //No se si usar Array o ArrayList para calcular los puntos y compararlos
        int valor = 0;
        if (pasar == 4) {
            for (Jugador j : nomJugador) {
                for (Ficha f : j.getFichasJugador()) {
                    //Completar sumar valor fichas para calcular ganador en caso de todos pasar
                }
            }
        } 

        return 0;
    }

    public void finalitzaJoc() {
            System.exit(0);
        }
    }

