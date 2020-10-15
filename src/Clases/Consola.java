package Clases;

import Exception.TrajeException;
import java.util.Scanner;

public class Consola extends Armadura {

    private final Scanner leer = new Scanner(System.in);

    public Consola() {
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
            System.out.println("No puedo continuar porque se ha destruido la consola");
        }
    }

    private void gastar(Traje t) {
        t.setEnergia(t.getEnergia() - 4);
        this.energia -= 4;
    }

    public String necesidad(Traje t){
        String s = "";
        if (this.energia > 0 && !this.destruido) {
            System.out.println("Hola Señor Stark, ¿Qué desea hacer?");
            System.out.println("- Caminar");
            System.out.println("- Correr");
            System.out.println("- Volar");
            System.out.println("- Disparar");
            check(t);
            s = leer.next();
        }
        return s;
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
