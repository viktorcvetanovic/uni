/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak3 {

    public static void popuniMatricu(int niz[][]) {
        Random r = new Random();
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz.length; j++) {
                niz[i][j] = r.nextInt(99) + 1;
            }
        }

    }

    public static void stampajMatricu(int niz[][]) {
        for (int i = 0; i < niz.length; i++) {
            System.out.println(Arrays.toString(niz[i]));
        }
    }

    public static void zbirKolona(int niz[][]) {

        for (int i = 0; i < niz.length; i++) {
            int zbir = 0;
            for (int j = 0; j < niz.length; j++) {
                zbir += niz[j][i];

            }
            System.out.println("Zbir " + i + "kolone je" + zbir);
        }
    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi broj kolona i redova");
        int n = tastatura.nextInt();
        int niz[][] = new int[n][n];
        popuniMatricu(niz);
        stampajMatricu(niz);
        zbirKolona(niz);
    }

}
