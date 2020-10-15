package Clases;

public class Bota extends Armadura {

    private String atri1;
    
    public Bota() {
        super();
    }

    public Bota(String colorP, String colorS, int resistencia, float hp) {
        super(colorP, colorS, resistencia, hp);
    }

    @Override
    public void check(int m, int n) {
        if ((int) (Math.random() * 100 + 1) < 30) {
            this.roto = true;
            this.hp -= 5;
        }
        if ((int) (Math.random() * 100 + 1) <= 40) {
            this.roto = false;
        }
        if (!this.roto) {
            gastar(m, n);
        } else {
            System.out.println("Las botas están rotas");
        }
        if (this.hp <= 0) {
            this.destruido = true;
            this.hp = 0;
        }
        if (this.destruido) {
            this.hp = 0;
            System.out.println("Las botas están destruidas");
        }
    }

    private void gastar(int m, int n) {
        if (this.energia >= m * n) {
            this.energia -= m * n;
        } else {
            if (this.energia == 0) {
                System.out.println("Ya no hay más energía en las botas");
            } else {
                System.out.println("No hay suficiente energía de las botas para esa cantidad, voy a hacerlo hasta que se agote la energía");
            }
        }
    }

    public void caminar(int m) {
        check(1, m);
    }

    public void correr(int m) {
        check(2, m);
    }

    public void propulsarse(int m) {
        check(3, m);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void check(Traje t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
