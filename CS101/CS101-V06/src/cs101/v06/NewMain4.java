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
public class NewMain4 {

    public static int najmanjiNiz(int niz[]) {
        int min = niz[0];
        for (int i = 0; i < niz.length; i++) {
            if (min > niz[i]) {
                min = niz[i];

            }
        }
        return min;
    }

    public static void main(String[] args) {
        int niz[] = {1, 53, 124, 5641, 2, 9, 3, 0};
        System.out.println(najmanjiNiz(niz));
    }

}
