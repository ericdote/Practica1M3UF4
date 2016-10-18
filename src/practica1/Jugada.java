package practica1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Jugada {
    
    private int turno;
    private ArrayDeque<Ficha> fichasTablero = new ArrayDeque();
    private boolean inicial = false;


    public Jugada(int turno) {
        this.turno = turno;
        
    }

    public Jugada() {
        
    }
    
    public void añadirFicha(){
        if (inicial == false){

        for (Ficha f : fichasJugador) {
            if (f.getDreta() == 6 && f.getEsquerra() == 6){
                trobat = true;
                break;
            }
        }        
    }
        }
        
    }

    public ArrayDeque<Ficha> getFichasTablero() {
        return fichasTablero;
    }

    public void setFichasTablero(ArrayDeque<Ficha> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }

    
    





    
    
    
    
    
      

}
