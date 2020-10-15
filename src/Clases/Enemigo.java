package Clases;

public class Enemigo {

    private int x;
    private int y;
    private int z;
    private int resistencia;

    public Enemigo(int x, int y, int z, int resistencia) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.resistencia = resistencia;
    }

    public Enemigo() {
        this.x = (int) (Math.random() * 4 + 1);
        this.y = (int) (Math.random() * 4 + 1);
        this.z = (int) (Math.random() * 4 + 1);
        this.resistencia = (int) (Math.random() * 40+1);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Enemigo{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
