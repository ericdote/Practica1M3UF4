package practica1;

import java.util.ArrayList;


public class Jugador {

    private String nom;
    public ArrayList<Ficha> fichasJugador;


    public Jugador(String nom) {
        this.nom = nom;
        fichasJugador = new ArrayList();
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