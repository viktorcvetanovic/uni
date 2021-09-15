/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.v06;

public class NewMain6 {

    public static void broji(int niz[]) {
        int count = 0;

        for (int broj : niz) {
            for (int i = 0; i < 10; i++) {
                if (i == broj) {
                    count += 1;

                }

            }

        }

    }

    public static void main(String[] args) {
        int niz[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 2, 3, 4, 5, 6, 4, 23, 43, 6, 45, 123, 54, 46, 412, 42, 124, 124};

    }

}
