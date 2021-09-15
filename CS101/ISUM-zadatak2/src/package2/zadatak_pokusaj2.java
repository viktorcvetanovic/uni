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
public class zadatak_pokusaj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int duzina = 0;
        List<String> list = new ArrayList<>();
        String s = "";
        while (true) {
            System.out.println("Unesi rec2");
            s = input.nextLine();
            if (s.equals("!done")) {
                break;
            } else if (duzina < s.length()) {
                duzina = s.length();
            }
            list.add(s);
        }
        System.out.print("**");
        for (int i = 0; i <= duzina; i++) {
            System.out.print("*");
        }
        System.out.print("*");
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print("* ");
            s = list.get(i);
            System.out.print(s);
            for (int j = s.length(); j <= duzina; j++) {
                System.out.print(" ");
            }
            System.out.println("*");

        }
        System.out.print("**");
        for (int i = 0; i <= duzina; i++) {
            System.out.print("*");
        }
        System.out.print("*");
        System.out.println();
    }

}
