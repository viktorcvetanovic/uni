/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak4 {

    public static int[] napuniNiz(int niz[]) {
        Random r = new Random();
        for (int i = 0; i < niz.length; i++) {
            niz[i] = r.nextInt(10);
        }
        return niz;
    }

    public static int[] sortirajNiz(int niz[]) {
        Arrays.sort(niz);
        return niz;
    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi velicinu niza");
        int n = tastatura.nextInt();
        int m = 2 * n;
        int niz[] = new int[m];
        int prvihN[] = new int[n];
        int drugihN[] = new int[n];
        napuniNiz(niz);
        System.out.println(Arrays.toString(niz));
        sortirajNiz(niz);
        System.out.println(Arrays.toString(niz));
        for (int i = 0; i < n; i++) {
            prvihN[i] = niz[i];
        }
        for (int i = 0; i < m - n; i++) {
            drugihN[i] = niz[n + i];
        }
        System.out.println(Arrays.toString(prvihN));
        System.out.println(Arrays.toString(drugihN));

    }

}
