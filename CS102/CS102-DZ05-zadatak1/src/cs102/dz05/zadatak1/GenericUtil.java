/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz05.zadatak1;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vikto
 */
public class GenericUtil {

    public static <T> List<T> brisiElemente(List<T> a, List<T> b) {
        return b.stream()
                .filter(e -> !a.stream().filter(e1 -> e1.equals(e)).findFirst().isPresent())
                .collect(Collectors.toList());
    }

    public static <T> List<T> brisiElemente2(List<T> a, List<T> b) {
        for (int i = 0; i < b.size(); i++) {
            if (a.contains(b.get(i))) {
                T s = b.remove(i);
                System.out.println(s);
            }
        }
        return b;
    }

    public static <T> int sadrzi(List<T> lista, T element) {
        return lista.stream()
                .filter(e -> e.equals(element))
                .collect(Collectors.toList())
                .size();
    }
}
