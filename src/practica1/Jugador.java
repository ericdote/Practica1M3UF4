package practica1;

import java.util.ArrayList;


public class Jugador {

    private String nom;
    private ArrayList<Ficha> fichasJugador = new ArrayList();


    public Jugador(String nom) {
        this.nom = nom;
    }

    public Jugador() {
    }


    public String getNom() {
        return nom;
    }

    public ArrayList<Ficha> getFichasJugador() {
        return fichasJugador;
    }
 
    public void añadirFicha(Ficha f){
        this.fichasJugador.add(f);
    }
    
}