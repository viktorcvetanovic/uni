/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package10;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kompjuter d = new Desktop("MSI", "Ryzen", "16", "1080", "500W", "GYGABITE");
        System.out.println(d);
        System.out.println(d.getCena());
        Kompjuter l = new Laptop("1500mah", "Intel", "8", "1050ti", "nema", "MSI");
        System.out.println(l);
        System.out.println(l.getCena());
    }

}
