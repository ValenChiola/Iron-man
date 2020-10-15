package Clases;

public class Guante extends Armadura {

    public Guante() {
        super();
    }

    @Override
    public void check(int m, int n) {
        if ((int) (Math.random() * 100 + 1) < 30) {
            this.roto = true;
            this.hp -= 5;
        } else if ((int) (Math.random() * 100 + 1) <= 40) {
            this.roto = false;
        } else if (!this.roto) {
            gastar(m, n);
        } else if(this.hp <= 0){
            this.destruido = true;
            this.hp = 0;
        }else if (this.destruido) {
            this.hp = 0;
            System.out.println(hp);
            System.out.println("Los guantes están destruidos");
        }
    }

    private void gastar(int m, int n) {
        if (this.energia >= n * m) {
            this.energia -= n * m;
        } else {
            if (this.energia == 0) {
                System.out.println("Ya no hay más energía en los guantes");
            } else {
                System.out.println("No hay suficiente energía de las botas para esa cantidad, voy a hacerlo hasta que se agote la energía");
            }
        }
    }

    public void volar(int m) {
        check(2, m);
    }

    public void disparar(int m) {
        check(3, m);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void check(Traje t) {
    }
}
