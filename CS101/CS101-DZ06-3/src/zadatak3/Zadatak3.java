/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak3 {

    public static int[] napuniNiz(int niz[]) {
        Scanner tastatura = new Scanner(System.in);
        for (int i = 0; i < niz.length; i++) {
            System.out.println("Unesi " + i + " element");
            niz[i] = tastatura.nextInt();
        }
        return niz;
    }

    public static void okreniNiz(int niz[]) {
        int niz2[] = new int[niz.length];
        int count = 0;
        for (int i = 1; i <= niz.length; i++) {
            niz2[count] = niz[niz.length - i];
            count++;
        }
        System.out.println(Arrays.toString(niz2));
    }

    public static void main(String[] args) {

        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi velicinu niza ");
        int n = tastatura.nextInt();
        int niz[] = new int[n];
        napuniNiz(niz);
        System.out.println(Arrays.toString(niz));
        okreniNiz(niz);

    }

}
