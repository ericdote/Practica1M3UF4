package practica1;

import java.util.ArrayList;


public class Jugador {

    private String nom;
    private ArrayList<Ficha> fichasJugador = new ArrayList();


    public Jugador(String nom) {
        this.nom = nom;
    }


    public void setFichasJugador(ArrayList<Ficha> fichasJugador) {
        this.fichasJugador = fichasJugador;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Ficha> getFichasJugador() {
        return fichasJugador;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
    
    public String mostraFichasJugador(){
        String fichaJugador="";
        for (int i = 0; i < fichasJugador.size(); i++) {
            fichaJugador += fichaJugador + i;
        }
        return fichaJugador;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nom=" + nom + ", fichasJugador=" + fichasJugador + '}';
    }


 

    

}