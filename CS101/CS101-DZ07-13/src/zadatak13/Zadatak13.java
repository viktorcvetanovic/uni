/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak13;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak13 {

    public static void napuniNiz(int niz[]) {
        Scanner tastatura = new Scanner(System.in);
        for (int i = 0; i < niz.length; i++) {
            System.out.println("Unesi " + i + " element niza");
            niz[i] = tastatura.nextInt();
        }
    }

    public static void promeniNiz(int niz[]) {
        int[] copiedArray = niz.clone();

        Scanner tastatura = new Scanner(System.in);
        System.out.println("Na kojoj poziciji zelite da zamenite element");
        int position = tastatura.nextInt();
        if (position < niz.length && position >= 0) {
            System.out.println("Koji broj?");
            int number = tastatura.nextInt();
            for (int i = 0; i < niz.length; i++) {

                copiedArray[position] = number;
            }
            System.out.println(Arrays.toString(niz));
            System.out.println(Arrays.toString(copiedArray));
        } else {
            System.out.println("Uneli ste nepostojecu poziciju");
        }

    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi velicinu niza");
        int n = tastatura.nextInt();
        int niz[] = new int[n];
        napuniNiz(niz);
        promeniNiz(niz);
        tastatura.close();
    }

}
