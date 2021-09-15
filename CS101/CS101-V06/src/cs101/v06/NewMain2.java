/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.v06;

/**
 *
 * @author vikto
 */
public class NewMain2 {

    public static void zbirNiz(int niz[]) {
        int zbir = 0;
        for (int i = 0; i < niz.length; i++) {
            zbir += niz[i];
        }
        System.out.println(zbir);
    }

    public static void main(String[] args) {
        int niz[] = {1, 5, 7, 4, 8, 16, 25};
        zbirNiz(niz);
    }

}
