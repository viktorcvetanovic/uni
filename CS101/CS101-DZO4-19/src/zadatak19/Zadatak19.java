/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak19;

import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String unos;
        int duzina, prvikarakter, resenje, zadnjikarakter;
        Scanner tastatura = new Scanner(System.in);
        System.out.println("Unesi tekst");
        unos = tastatura.nextLine();
        duzina = unos.length();
        prvikarakter = unos.charAt(0);
        zadnjikarakter = unos.charAt(unos.length() - 1);
        resenje = (duzina * prvikarakter) / zadnjikarakter;
        System.out.println(duzina);
        System.out.println(prvikarakter);
        System.out.println(zadnjikarakter);
        System.out.println("Resenje je: " + resenje);
        tastatura.close();
    }
}
