/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak11;

/**
 *
 * @author vikto
 */
public class Zadatak11 {

    public static void broj() {
        double zbir;
        double zbir1 = 0;
        double zbir2 = 0;
        for (double i = 0; i <= 1000; i += 2) {
            zbir1 += i;
        }
        for (double i = 0; i <= 500; i = i + 1) {
            zbir2 += i;
        }
        zbir = zbir1 - zbir2;
        System.out.printf("%.2f", zbir);

    }

    public static void main(String[] args) {
        broj();
    }

}
