/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.v06;

import java.util.Arrays;

/**
 *
 * @author vikto
 */
public class NewMain1 {

    public static void neparanNiz(int niz[]) {
        for (int i = 0; i < niz.length; i++) {
            niz[i] = i + (i + 1);

        }
        System.out.println(Arrays.toString(niz));
    }

    public static void dvaneparanNiz(int niz[]) {
        for (int i = 0; i < niz.length; i++) {
            niz[i] = 2 * niz[i];
        }
        System.out.println(Arrays.toString(niz));
    }

    public static void main(String[] args) {
        int niz[] = new int[10];
        neparanNiz(niz);
        dvaneparanNiz(niz);
    }

}
