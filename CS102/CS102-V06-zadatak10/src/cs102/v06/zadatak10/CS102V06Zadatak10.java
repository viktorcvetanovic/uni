/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak10;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static <T> T[] prosiriNiz(T[] niz, T[] niz2, int broj) {
        T[] newNiz = (T[]) new Object[niz.length + broj];
        int pom = 0;
        for (int i = 0; i < newNiz.length; i++) {
            if (i < niz.length) {
                newNiz[i] = niz[i];
            } else {
                niz[i] = niz2[pom];
                pom++;
            }
        }
        return newNiz;
    }
}
