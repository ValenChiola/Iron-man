package Clases;

import java.util.Scanner;

public class Traje {

    Scanner leer = new Scanner(System.in);
    private Bota b1 = new Bota();
    private Guante g1 = new Guante();
    private Consola c = new Consola();
    private Sintetizador s = new Sintetizador();
    private int energia;
    private float[] radar;

    public Traje() {
        this.energia = (int) (b1.getEnergia() + g1.getEnergia() + c.getEnergia() + s.getEnergia());
        this.radar = new float[10];
    }

    public float[] getRadar() {
        return radar;
    }

    public void setRadar(float[] radar) {
        this.radar = radar;
    }

    public Bota getB1() {
        return b1;
    }

    public void setB1(Bota b1) {
        this.b1 = b1;
    }

    public Guante getG1() {
        return g1;
    }

    public void setG1(Guante g1) {
        this.g1 = g1;
    }

    public Consola getC() {
        return c;
    }

    public void setC(Consola c) {
        this.c = c;
    }

    public Sintetizador getS() {
        return s;
    }

    public void setS(Sintetizador s) {
        this.s = s;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "Armadura{" + "Bota=" + b1 + ", Guante=" + g1 + ", Consola=" + c + ", Sintetizador=" + s + '}';
    }
}
