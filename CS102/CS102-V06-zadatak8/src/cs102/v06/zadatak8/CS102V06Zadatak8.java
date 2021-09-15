/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak8 {

    public static void main(String[] args) {
        System.out.println(razlikaNizova(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5)));
    }

    public static <T> List<T> razlikaNizova(List<T> niz, List<T> niz2) {
        List<T> lista = new ArrayList<>();
        for (int i = 0; i < niz.size(); i++) {
            for (int j = 0; j < niz2.size(); j++) {
                if (!niz.get(i).equals(niz.get(j))) {
                    lista.add(niz.get(j));
                }
            }
        }
        return lista;
    }

}
