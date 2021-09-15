/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak2 {

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

    public static int glavnaDijagonala(int niz[][]) {
        int zbir = 0;
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz.length; j++) {
                if (i == j) {
                    zbir += niz[i][j];
                }
            }

        }
        return zbir;
    }

    public static int sporednaDijagonala(int niz[][]) {
        int zbir = 0;
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz.length; j++) {
                if (i + j == niz.length - 1) {
                    zbir += niz[i][j];
                }
            }

        }
        return zbir;
    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi broj kolona i redova");
        int n = tastatura.nextInt();
        int niz[][] = new int[n][n];
        popuniMatricu(niz);
        stampajMatricu(niz);
        System.out.println(Math.max(glavnaDijagonala(niz), sporednaDijagonala(niz)));
    }

}
