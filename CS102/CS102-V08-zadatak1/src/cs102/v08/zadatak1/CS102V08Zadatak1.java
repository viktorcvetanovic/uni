/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v08.zadatak1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author vikto
 */
public class CS102V08Zadatak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rec = "Java je programski jezik. Java je zabavna. ";
        List<String> lista = Arrays.asList(rec.split(" "));
        replaceElement(lista, ".");

        Map<String, Long> map = lista.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

        System.out.println(lista);
        System.out.println(map);
    }

    public static void replaceElement(List<String> lista, String element) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).contains(element)) {
                lista.set(i, lista.get(i).replace(element, ""));
            }
        }
    }
}
