/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak13;

import java.util.Arrays;

/**
 *
 * @author vikto
 */
public class Zadatak13 {

    public static void broj(double... n) {
        double min = 0;
        int pozicija = 0;
        for (int i = 0; i < n.length; i++) {
            min = n[0];
            if (min > n[i]) {
                min = n[i];
                pozicija = i;
            }
        }
        System.out.println("Najmanji broj je " + min + " i nalazi se na " + pozicija + " mestu");
    }

    public static void main(String[] args) {
        broj(-1);
    }

}
