/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak1 {

    public static int[][] napuniNiz(int niz[][]) {
        Random r = new Random();

        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz[i].length; j++) {
                int a = r.nextInt(10);
                niz[i][j] = a;
            }
        }
        return niz;
    }

    public static void kvadrirajNiz(int niz[][]) {
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz[i].length; j++) {

                niz[i][j] *= niz[i][j];
            }
        }
        System.out.println(Arrays.deepToString(niz));
    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi prvu dimenziju niza");
        int n = tastatura.nextInt();
        System.out.println("Unesi drugu dimenziju niza");
        int m = tastatura.nextInt();
        int niz[][] = new int[n][m];
        napuniNiz(niz);
        System.out.println(Arrays.deepToString(niz));
        kvadrirajNiz(niz);

        tastatura.close();
    }

}
