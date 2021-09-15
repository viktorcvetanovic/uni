/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pas pas = new Pas("viktor", "staford");
        Zivotinja pas2 = pas;
        Zivotinja macka = new Macka("fsfs", "fsfs");
        Macka macka2 = (Macka) macka;
        ispitaj(macka2);
    }

    public static boolean ispitaj(Zivotinja z) {
        if (z instanceof Macka) {
            Macka m = (Macka) z;
            if (m.getRasa().equals("persijska macka")) {
                return true;
            }
        }
        return false;
    }

}
