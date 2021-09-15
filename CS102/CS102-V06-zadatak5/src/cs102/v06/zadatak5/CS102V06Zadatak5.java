/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> brojevi = new ArrayList<>();
        brojevi.add(1);
        brojevi.add(3);
        System.out.println(ukloniElemente(2, brojevi));
    }

    public static <T extends Comparable> List<T> ukloniElemente(T vrednost, List<T> lista) {
        lista.removeIf((T t) -> t.compareTo(vrednost) == 1);
        return lista;
    }

}
