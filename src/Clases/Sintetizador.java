package Clases;

import java.util.Scanner;

public class Sintetizador extends Armadura {

    private Scanner leer = new Scanner(System.in);

    public Sintetizador() {
        super();
        this.colorP = "Negro";
        this.colorS = "Gris";
    }

    @Override
    public void check(Traje t) {
        if ((int) (Math.random() * 100 + 1) < 30) {
            this.roto = true;
        }
        if ((int) (Math.random() * 100 + 1) <= 40) {
            this.roto = false;
        }
        if (!this.roto) {
            gastar(t);
        }
        if (this.destruido) {
            t.setEnergia((int) (t.getEnergia() - this.energia));
            this.energia = 0;
        }
    }

    private void gastar(Traje t) {
        t.setEnergia(t.getEnergia() - 1);
        this.energia -= 1;
    }

    public void escribir(Traje t) {
        if (this.energia > 0 && !this.destruido) {
            if (t.getEnergia() < 60) {
                System.out.println("Energía de la armadura nivel crítico " + (t.getEnergia() / 4) + "%");
                check(t);
            } else {
                gastar(t);
                System.out.println("Energía de la armadura: " + (t.getEnergia() / 4) + "%");
            }
        }
    }

    public void escribir(Traje t, String s) {
        if (this.energia > 0 && !this.destruido) {
            gastar(t);
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void check(int n, int m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
