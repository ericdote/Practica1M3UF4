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
        //For per asignar els noms als jugadors
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
                nomJugador.get(j).getFichasJugador().add(fichas.get(aleatorio));
//                nomJugador.get(j).añadirFicha(fichas.get(aleatorio));
                fichas.remove(aleatorio);
            }
        }
    }
    
    private int jugadorInicial() {
        //Recorre los diferentes jugadores mirando las fichas que tiene en conjunto con el metodo que tenemos en Jugador para ir mirando las fichas en el ArrayList
        //Del Jugador que le toca, si es el jugador lo muestra por pantalla y lo asigna a una variable para comenzar con el la partida.
//        int contador=0; 
        int jugador = 0;
//        Ficha f = ;
        for (Jugador j : nomJugador) {
            if (j.getFichasJugador().contains(new Ficha(6, 6))){
                System.out.println(j.getNom());
                jugador = nomJugador.indexOf(j);
            }
//            System.out.println(nomJugador.indexOf(j));
//            if (j.getFichasJugador().contains(f)) {
//                jugador = nomJugador.indexOf(j);
////                jugador = contador;
//                break;
//            }
//            contador++;
        }

//        ArrayList<Ficha> fichas = jug.getFichasJugador();
//        for (int i = 0; i < nomJugador.size(); i++) {
//            if (nomJugador.get(i).trobarFichaIncial()) {
//                jugador = i;
//                break;
//            }
//        }
        return jugador;
        
    }
    
//    public void turnos() {
//        turno = jugador;
//        
//    }
}
