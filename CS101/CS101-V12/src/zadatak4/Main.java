/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> brojevi = new ArrayList<>();
        List<Integer> brojevi2 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            brojevi.add(i);
        }
        for (int i = 5; i < 15; i++) {
            brojevi2.add(i);
        }

        System.out.println(zajednicka(brojevi, brojevi2));
        System.out.println(maxElement(brojevi2));

    }

    public static List<Integer> zajednicka(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a.get(i) == b.get(j)) {
                    c.add(a.get(i));
                }
            }
        }
        return c;
    }

    public static int maxElement(List<Integer> a) {
        int max = Integer.MIN_VALUE;
        for (Integer i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
