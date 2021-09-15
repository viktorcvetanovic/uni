/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prozor p1 = new Prozor(24, 32, 22, 2000);
        Prozor p2 = new Prozor(24, 32, 22, 2000);
        Prozor p3 = new Prozor(24, 32, 22, 2000);
        List<Prozor> lista = new ArrayList<Prozor>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        /* Arrays.asList(p1, p2, p3);*/
        Isporuka i1 = new Isporuka("Somborska", 4000, lista);
        i1.priceUpdater();
        System.out.println(i1.getPrice());
        Firma f1 = new Firma();
        f1.addIsporuka(i1);
        System.out.print(f1);

    }

}
