/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak17;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak17 {

    public static void spojiNiz(int niza[], int nizb[]) {
        int duzina = niza.length + nizb.length;

        int niz[] = new int[duzina];
        int count = 0;
        for (int i = 0; i < duzina; i++) {
            if (i < niza.length) {
                niz[i] = niza[i];
            } else {
                niz[i] = nizb[count];
                count++;
            }

        }
        System.out.println(Arrays.toString(niz));

    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi dimenziju prvog niza");
        int a = tastatura.nextInt();
        System.out.println("Unesi dimenziju drugog niza");
        int b = tastatura.nextInt();
        int niza[] = new int[a];
        int nizb[] = new int[b];
        for (int i = 0; i < a; i++) {
            System.out.println("Unesi " + i + " element PRVOG niza");
            niza[i] = tastatura.nextInt();
        }
        for (int i = 0; i < b; i++) {
            System.out.println("Unesi " + i + " element DRUGOG niza");
            nizb[i] = tastatura.nextInt();
        }
        spojiNiz(niza, nizb);

    }

}
