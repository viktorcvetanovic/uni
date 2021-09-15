/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak9;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak9 {

    public static int[] napuniNiz(int niz[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < niz.length; i++) {
            System.out.print("Unesite element: ");
            niz[i] = scanner.nextInt();
        }
        return niz;
    }

    public static boolean sortNiz(int niz[]) {
        boolean a = false;
        int count = 0;
        while (count + 1 < niz.length) {
            if (niz[count] < niz[count + 1]) {
                count++;
                a = true;
            } else {

                a = false;
                break;
            }

        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");

        int n = scanner.nextInt();
        int[] niz = new int[n];
        napuniNiz(niz);
        System.out.println(Arrays.toString(niz));
        System.out.println(sortNiz(niz));

    }

}
