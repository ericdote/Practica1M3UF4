package practica1;

import java.util.ArrayList;
import java.util.List;


public class Ficha {
    
    private int esquerra, dreta;

    @Override
    public String toString() {
        return "Ficha{" + "esquerra=" + esquerra + ", dreta=" + dreta + '}';
    }
    
    public Ficha(int a, int b) {
        this.esquerra = a;
        this.dreta = b;
    }

    public int getEsquerra() {
        return esquerra;
    }

    public void setEsquerra(int esquerra) {
        this.esquerra = esquerra;
    }

    public int getDreta() {
        return dreta;
    }

    public void setDreta(int dreta) {
        this.dreta = dreta;
    }

    public Ficha() {
    }
    
    


    
    
      
    
    
    }

