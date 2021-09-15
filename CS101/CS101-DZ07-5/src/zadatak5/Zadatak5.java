/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak5 {

    public static int[][] praviNiz(int n, int m) {
        int niz[][] = new int[n][m];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                niz[i][j] = r.nextInt(9) + 1;
            }
        }
        return niz;
    }

    public static int[] sporednaDijagonala(int niz[][]) {
        int lista[] = new int[niz.length];
        int[][] copiedArray = Arrays.copyOf(niz, niz.length);
        for (int i = 0; i < copiedArray.length; i++) {
            for (int j = 0; j < copiedArray[i].length; j++) {
                if (i + j == copiedArray.length - 1) {
                    lista[i] = copiedArray[i][j];

                }
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi prvu dimenziju matrice");
        int n = tastatura.nextInt();
        System.out.println("Unesi drugu dimenziju matrice");
        int m = tastatura.nextInt();
        int niz[][];
        niz = praviNiz(n, m);
        System.out.println(Arrays.deepToString(niz));
        System.out.println(Arrays.toString(sporednaDijagonala(niz)));

    }

}
