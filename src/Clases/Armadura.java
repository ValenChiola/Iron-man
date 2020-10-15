package Clases;

public abstract class Armadura {

    protected boolean destruido;
    protected boolean roto;
    protected String colorP;
    protected String colorS;
    protected int resistencia;
    protected float hp;
    protected float energia = 100;

    public Armadura(String colorP, String colorS, int resistencia, float hp) {
        this.colorP = colorP;
        this.colorS = colorS;
        this.resistencia = resistencia;
        this.hp = hp;
    }

    public Armadura() {
        this.colorP = "Rojo";
        this.colorS = "Dorado";
        this.hp = 100;
        this.resistencia = 100;
    }

    public boolean isDestruido() {
        return destruido;
    }

    public void setDestruido(boolean destruido) {
        this.destruido = destruido;
    }

    public boolean isRoto() {
        return roto;
    }

    public void setRoto(boolean roto) {
        this.roto = roto;
    }

    public String getColorP() {
        return colorP;
    }

    public void setColorP(String colorP) {
        this.colorP = colorP;
    }

    public String getColorS() {
        return colorS;
    }

    public void setColorS(String colorS) {
        this.colorS = colorS;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public abstract void check(int n, int m);

    public abstract void check(Traje t);

    @Override
    public String toString() {
        return "Armadura{" + "destruido=" + destruido + ", roto=" + roto + ", colorP=" + colorP + ", colorS=" + colorS + ", resistencia=" + resistencia + ", hp=" + hp + ", energia=" + energia + "%" + '}';
    }

  
}
