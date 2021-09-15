/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak6 {

    public static void brojPoena(int n) {
        int niz[] = new int[n];
        for (int i = 0; i < n; i++) {

            int poeni = (int) (Math.floor(Math.random() * (100 - 50 + 1)) + 50);
            niz[i] = poeni;
            if (poeni > 50 && poeni <= 61) {
                System.out.println("Ocena je 6 a broj poena je " + poeni);
            } else if (poeni > 61 && poeni <= 71) {
                System.out.println("Ocena je 7 a broj poena je " + poeni);
            } else if (poeni > 71 && poeni <= 81) {
                System.out.println("Ocena je 8 a broj poena je " + poeni);
            } else if (poeni > 81 && poeni <= 91) {
                System.out.println("Ocena je 9 a broj poena je " + poeni);
            } else {
                System.out.println("Ocena je 10 a broj poena je " + poeni);
            }

        }
        System.out.println(Arrays.toString(niz));

    }

    public static void main(String[] args) {
        int n;

        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesite broj clanova");
        n = tastatura.nextInt();
        brojPoena(n);
    }

}
