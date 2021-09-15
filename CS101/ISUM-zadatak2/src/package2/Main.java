/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Unesti reci koje zelite da printa(!done je za kraj)");
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int duzina = 0;

        while (true) {

            System.out.println("Unesti rec");
            String a = sc.nextLine();
            if (a.equals("!done")) {
                break;
            } else if (a.length() > duzina) {
                duzina = a.length();
            }

            list.add(a);

        }

        duzina = duzina + 2;
        int duzinaListe = list.size() + 2;
        int count = 0;

        for (int i = 0; i < duzinaListe; i++) {
            System.out.println();

            for (int j = 0; j < duzina; j++) {

                if (i == 0 || i == duzinaListe - 1) {
                    System.out.print("*");
                }
                if (j == 0 || j == duzina - 1) {
                    System.out.print("*");
                }

                if (i > 0 && i < duzinaListe - 1) {
                    if (j == 1) {
                        System.out.print(list.get(count));
                        count++;
                    } else {
                        System.out.print(" ");

                    }

                }

            }

        }
    }
}
