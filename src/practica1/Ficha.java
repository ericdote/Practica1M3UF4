package practica1;

import java.util.ArrayList;
import java.util.List;

public class Ficha {

    private int esquerra, dreta;

    public Ficha(int a, int b) {
        this.esquerra = a;
        this.dreta = b;
    }

    public void setEsquerra(int esquerra) {
        this.esquerra = esquerra;
    }

    public void setDreta(int dreta) {
        this.dreta = dreta;
    }

    public int getEsquerra() {
        return esquerra;
    }

    public int getDreta() {
        return dreta;
    }

    public Ficha() {
    }
}
