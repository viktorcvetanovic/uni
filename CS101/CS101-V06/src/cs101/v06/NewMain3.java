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
public class NewMain3 {

    public static int prosekNiz(int niz[]) {
        int prosek = 0;
        for (int i = 0; i < niz.length; i++) {
            prosek += niz[i];
        }
        prosek = (int) (prosek / (double) niz.length);
        return prosek;
    }

    public static void main(String[] args) {
        int niz[] = {1, 65, 34, 765, 123, 43};
        System.out.println(prosekNiz(niz));

    }

}
