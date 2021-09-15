/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package3;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {

    public static int randomBroj() {
        Random r = new Random();
        Date date = new Date();
        int datum = date.getDate();
        int num = (int) (Math.floor(Math.random() * datum));
        if (r.nextBoolean()) {
            return num *= -1;
        }
        return num;
    }

    public static int[][] srediDeterminantu(int[][] determinanta) {
        for (int i = 0; i < determinanta.length; i++) {
            for (int j = 0; j < determinanta[i].length; j++) {
                if (i == j) {
                    if (determinanta[i][j] % 2 != 0) {
                        if (determinanta[i][j] > 0) {
                            determinanta[i][j] = determinanta[i][j] - 1;
                        } else {
                            determinanta[i][j] = determinanta[i][j] + 1;
                        }
                    }

                }

            }
        }
        return determinanta;
    }

    public static void racunajDeterminantu(int[][] a) {
        int x = a[0][0] * ((a[1][1] * a[2][2]) - (a[2][1] * a[1][2]));
        int y = -a[0][1] * ((a[0][1] * a[2][2]) - (a[2][0] * a[1][2]));
        int z = a[0][2] * ((a[1][0] * a[2][1]) - (a[1][1] * a[2][0]));

        int r = x + y + z;
        System.out.println(r);
    }

    public static void main(String[] args) {
        int[][] determinanta = new int[3][3];
        for (int i = 0; i < determinanta.length; i++) {
            for (int j = 0; j < determinanta[i].length; j++) {
                determinanta[i][j] = randomBroj();
            }
        }
        System.out.println(Arrays.deepToString(determinanta));
        determinanta = srediDeterminantu(determinanta);
        System.out.println(Arrays.deepToString(determinanta));
        racunajDeterminantu(determinanta);

    }

}
