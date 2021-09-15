/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak9;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static <T extends Number> Double aritmetickaSredina(T... niz) {
        double suma = 0;
        for (int i = 0; i < niz.length; i++) {
            suma += niz[i].doubleValue();
        }
        return suma / niz.length;
    }

}
