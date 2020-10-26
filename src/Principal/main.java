package Principal;

import Clases.Traje;
import Exception.TrajeException;
import Service.TrajeService;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        //Creo un TrajeService y un Traje
        TrajeService ts = new TrajeService();
        Traje traje = ts.returnTraje();

        System.out.println("Iniciando software... por favor espere");

        //Esperar 4 seg antes de empezar
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        //Uso el traje hasta que se le acabe la energia
        do {
            //Controlo las posibles exepciones
            try {
                ts.usar(traje);
            } catch (TrajeException e) {
                System.out.println(e.getMessage());
            }
            ts.radar(traje);
            if (traje.getEnergia() <= 0) {
                break;
            }
            traje.getS().escribir(traje);
            System.out.println(traje.toString());
        } while (traje.getC().getEnergia() > 0);
        System.out.println("Ey tony te quedaste sin energía?");
    }
}
