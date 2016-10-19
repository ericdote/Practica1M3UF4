package practica1;

import java.util.ArrayList;


public class Jugador {

    private String nom;
    private ArrayList<Ficha> fichasJugador;


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

    
    
//    public boolean trobarFichaIncial(){
//        boolean trobat = false;
//        for (Ficha f : fichasJugador) {
//            if (f.getDreta() == 6 && f.getEsquerra() == 6){
//                trobat = true;
//                break;
//            }
//        }        
//        return trobat;
//    }
    
    
    @Override
    public String toString() {
        return "Jugador{" + "nom=" + nom + ", fichasJugador=" + fichasJugador + '}';
    }


 

    

}