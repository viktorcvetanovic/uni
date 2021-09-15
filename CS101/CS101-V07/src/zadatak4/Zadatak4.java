/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import static zadatak3.Zadatak3.popuniMatricu;
import static zadatak3.Zadatak3.stampajMatricu;

/**
 *
 * @author vikto
 */
public class Zadatak4 {

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

    public static void zameniMAXMIN(int niz[][]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz.length; j++) {
                if (niz[i][j] < min) {
                    min = niz[i][j];
                } else if (niz[i][j] > max) {
                    max = niz[i][j];

                }
            }
        }
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz.length; j++) {
                if (niz[i][j] == min) {
                    niz[i][j] = max;

                } else if (niz[i][j] == max) {
                    niz[i][j] = min;
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi broj kolona i redova");
        int n = tastatura.nextInt();
        int niz[][] = new int[n][n];
        popuniMatricu(niz);
        stampajMatricu(niz);
        zameniMAXMIN(niz);
        System.out.println("-------------------");
        stampajMatricu(niz);
    }

}
