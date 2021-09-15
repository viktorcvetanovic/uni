/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.util.Scanner;

/**
 *
 * @author student
 */
public class Zadatak1 {

    public static void ocena(int unos) {
        if (unos >= 5 && unos <= 10) {
            if (unos >= 5 && unos <= 7) {
                System.out.println("Los student");
            } else if (unos > 7 && unos < 9) {
                System.out.println("Dobar student");
            } else {

                System.out.println("Odlican student");
            }
        } else {
            System.out.println("Uneli ste pogresnu vrednost");

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int k = 0;
        Scanner tastatura = new Scanner(System.in);

        System.out.println("Unesi broj indeksa");
        int unos = tastatura.nextInt();
        ocena(unos);
        tastatura.close();

    }

}
