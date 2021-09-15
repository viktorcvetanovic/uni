/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int broj, a = 1;
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesite broj");
        broj = tastatura.nextInt();

        for (int i = 1; i <= broj; i++) {
            a = a * i;
            System.out.println(a);
        }

        tastatura.close();
    }

}
