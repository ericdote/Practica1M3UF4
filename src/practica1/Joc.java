package practica1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc {
    
    Scanner lector = new Scanner(System.in);
    private ArrayList<Ficha> fichas;
    private ArrayList<Jugador> nomJugador;
//    private int jugador;
    private int turno;
    private ArrayDeque<Ficha> fichasTablero;
    
    public Joc() {
        fichasTablero = new ArrayDeque();
        afegirFichas();
        crearJugadors();
        
        asignarFichas();
        for(Jugador j : nomJugador){
            System.out.println(j.toString());
        }
        System.out.println(jugadorInicial());

//        turnos();
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

    //  Restem -48 per que es on començen els numerics a la taula ASCII.
    private int jugadorInicial() {
        int jugador = 0;
        for (Jugador j : nomJugador) {
            if (j.getFichasJugador().contains(fichas.get(fichas.size() - 1))) {
                jugador = nomJugador.indexOf(j);
                break;
            }
        }
        return jugador;
    }
    
//    public void turnos() {
//        turno = jugador;
//        
//    }
}
