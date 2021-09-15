/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.v06;

import java.util.Arrays;

public class CS101V06 {

    public static void ispisiNiz(int[] niz) {
        for (int i = 0; i < niz.length; i++) {
            niz[i] = (2 * i) * (2 * i);

        }
        System.out.println(Arrays.toString(niz));
    }

    public static void main(String[] args) {
        int niz[] = new int[100];
        ispisiNiz(niz);
    }

}
