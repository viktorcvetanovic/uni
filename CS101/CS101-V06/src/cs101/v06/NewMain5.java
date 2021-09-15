/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.v06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class NewMain5 {

    public static int[] niz(int n, int min, int max) {
        int niz[] = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            int a = r.nextInt(max - min) + min;
            niz[i] = a;
        }
        return niz;
    }

    public static void main(String[] args) {
        int n, min, max;
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesite duzinu");
        n = tastatura.nextInt();
        System.out.println("Unesite min");
        min = tastatura.nextInt();
        System.out.println("Unesite max");
        max = tastatura.nextInt();
        System.out.println(Arrays.toString(niz(n, min, max)));
    }

}
