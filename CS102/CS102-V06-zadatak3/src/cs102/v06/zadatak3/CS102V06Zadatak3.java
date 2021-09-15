/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(obrnutRaspored(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    public static <T> List<T> obrnutRaspored(List<T> lista) {
        Collections.reverse(lista);
        return lista;
    }

}
