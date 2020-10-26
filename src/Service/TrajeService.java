package Service;

import Clases.Armadura;
import Clases.Enemigo;
import Clases.Traje;
import Exception.TrajeException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrajeService {

    private final Scanner leer = new Scanner(System.in);

    public Traje returnTraje() {
        return new Traje();
    }

    private void gastar(int m, Armadura a, Traje t) {
        if (!a.isRoto() && !a.isDestruido()) {
            if (a.getEnergia() >= m) {
                t.setEnergia(t.getEnergia() - m);
            } else {
                t.setEnergia((int) (t.getEnergia() - a.getEnergia()));
                a.setEnergia(0);
                System.out.println("Hola 1");
            }
        } else {
            if (!a.isDestruido()) {
                boolean ready = reparandoDispositivos(a);
                if (!ready) {
                    do {
                        ready = reparandoDispositivos(a);
                    } while (ready || !a.isRoto());
                }
            } else {
                t.setEnergia((int) (t.getEnergia() - a.getEnergia()));
                a.setEnergia(0);
                a.setHp(0);
            }
        }
    }

    private boolean reparandoDispositivos(Armadura a) {
        boolean ready = false;
        if ((int) (Math.random() * 100 + 1) < 30) {
            a.setRoto(true);
        } else if ((int) (Math.random() * 100 + 1) <= 40) {
            a.setRoto(false);
        }
        if ((int) (Math.random() * 100 + 1) < 5) {
            a.setDestruido(true);
            ready = true;
        }
        return ready;
    }

    public void radar(Traje t) {
        boolean hostil;
        boolean ya = false;
        int ne = 0;
        for (int i = 0; i < 10; i++) {
            Enemigo e = new Enemigo();
            hostil = true;
            if ((int) (Math.random() * 100 + 1) <= 50) {
                hostil = false;
            }
            float d = (float) (Math.sqrt(e.getX() * e.getX() + e.getY() * e.getY() + e.getZ() * e.getZ()));
            t.getRadar()[i] = d;
            if (hostil) {
                ne++;

                //Destruyendo enemigos
                if (t.getEnergia() > 40) {
                    if (d <= 5) {
                        t.getS().escribir(t, "El enemigo " + ne + " se encuentra a " + t.getRadar()[i] + "km. Coordenadas:"
                                + " (" + e.getX() + ", " + e.getY() + ", " + e.getZ() + ")");
                        do {
                            if (t.getG1().isDestruido()) {
                                t.getS().escribir(t, "Los guantes están destruidos");
                                return;
                            }
                            int power = (int) (Math.random() * 10 + 1);
                            if (!t.getG1().isDestruido() && t.getG1().getEnergia() - power >= 0) {
                                t.getG1().disparar(power);
                                gastar(3 * power, t.getG1(), t);
                                e.setResistencia(e.getResistencia() - power);
                                if (e.getResistencia() <= 0) {
                                    t.getS().escribir(t, "El enemingo " + ne + " ha sido destruido");
                                } else {
                                    t.getS().escribir(t, "Resistencia del enemigo " + ne + ": " + e.getResistencia());
                                }
                            } else {
                                t.getS().escribir(t, "No hay energía de los guantes, vamos a morir");
                                return;
                            }
                        } while (e.getResistencia() > 0);
                    } else {
                        t.getS().escribir(t, "El enemigo " + ne + " está fuera del alcance");
                    }
                } else {
                    if (!ya) {
                        accionesEvasivas(t);
                        ya = true;
                    }
                }
            }
        }
        ya = false;
    }

    private void accionesEvasivas(Traje t) {
        if (t.getB1().getEnergia() - 3 >= 0 && t.getG1().getEnergia() - 2 >= 0) {
            t.getG1().volar(1);
            gastar(3, t.getG1(), t);
            t.getB1().propulsarse(1);
            gastar(2, t.getB1(), t);
            t.getS().escribir(t, "Acciones evasivas con éxito");
        } else {
            t.getS().escribir(t, "Lo siento, no alcanza la energía, vamos a morir");
        }
    }

    private void error(int m) throws TrajeException {
        if (m < 0) {
            throw new TrajeException("Tiene que ser positivo");
        }
    }

    public void usar(Traje t) throws TrajeException {
        int m;
        try {
            switch (t.getC().necesidad(t).toLowerCase()) {
                case "caminar":
                    System.out.println("Por cúanto tiempo desea caminar?");
                    m = leer.nextInt();
                    error(m);
                    t.getB1().caminar(m);
                    gastar(m, t.getB1(), t);
                    break;

                case "correr":
                    System.out.println("Por cúanto tiempo desea correr?");
                    m = leer.nextInt();
                    error(m);
                    gastar(2 * m, t.getB1(), t);
                    t.getB1().correr(m);
                    break;

                case "volar":
                    System.out.println("Por cúanto tiempo desea volar?");
                    m = leer.nextInt();
                    error(m);
                    gastar(3 * m, t.getB1(), t);
                    t.getB1().propulsarse(m);
                    gastar(2 * m, t.getG1(), t);
                    t.getG1().volar(m);
                    break;

                case "disparar":
                    System.out.println("Por cúanto tiempo desea disparar?");
                    m = leer.nextInt();
                    error(m);
                    gastar(3 * m, t.getG1(), t);
                    t.getG1().disparar(m);
                    break;

                default:
                    if (t.getS().getEnergia() > 0) {
                        t.getS().escribir(t, "Lo siento, eso todavía no está incorporado");
                    }
                    break;
            }
        } catch (TrajeException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Debe ser un número y entero ");
            leer.next();
        } catch (NullPointerException e) {
            return;
        }
    }
}
