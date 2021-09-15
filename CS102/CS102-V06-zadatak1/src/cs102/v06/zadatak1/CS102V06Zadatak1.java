/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak1;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak1 {

    public static void main(String[] args) {
        System.out.println(indeks(Arrays.asList("dva", "tri", "dva", "tri"), "tri"));
    }

    public static <T> int indeks(List<T> lista, T element) {
        Integer indeks = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(element)) {
                indeks = i;
            }
        }
        return indeks;
    }
}
