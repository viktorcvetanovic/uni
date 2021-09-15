/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak2;

import java.util.Arrays;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer niz[] = {1, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(sort(1, niz)));
    }

    public static <T extends Comparable> T[] sort(int indikator, T... niz) {

        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz.length; j++) {
                int pom = i;
                if (niz[i].compareTo(niz[j]) == -indikator) {
                    pom = j;
                }
                T temp = niz[pom];
                niz[pom] = niz[i];
                niz[i] = temp;
            }
        }
        return niz;
    }
}
