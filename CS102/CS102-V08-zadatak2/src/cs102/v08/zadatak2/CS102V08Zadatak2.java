/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v08.zadatak2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author vikto
 */
public class CS102V08Zadatak2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));

        Set<String> set2 = new LinkedHashSet<>();
        set2.addAll(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

        Set<String> union = unijaSetova(set, set2);
        System.out.println(union);

        Set<String> razlika = razlikaSetova(set, set2);
        System.out.println(razlika);
    }

    public static Set<String> unijaSetova(Set<String> set, Set<String> set2) {
        Set<String> union = new LinkedHashSet<>();
        union.addAll(set);
        union.addAll(set2);
        return union;
    }

    public static Set<String> razlikaSetova(Set<String> set, Set<String> set2) {
        Set<String> razlika = new LinkedHashSet<>();
        razlika.addAll(set);
        razlika.removeAll(set2);

        return razlika;

    }

}
