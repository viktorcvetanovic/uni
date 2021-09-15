/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak1 {

    public static void stampaNiz(int niz[][]) {
        Random r = new Random();
        int brojac = 0;
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz[i].length; j++) {
                niz[i][j] = r.nextInt(99) + 1;
                if (niz[i][j] % 2 == 0) {
                    brojac += 1;
                }
            }
        }
        System.out.println(brojac);
    }

    public static void main(String[] args) {
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi broj kolona");
        int n = tastatura.nextInt();
        System.out.println("Unesi broj redova");
        int m = tastatura.nextInt();
        int niz[][] = new int[n][m];
        stampaNiz(niz);
        tastatura.close();
    }

}
