/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v08.zadatak4;

import static cs102.v08.zadatak4.Util.generateNumber;
import static cs102.v08.zadatak4.Util.gerenateString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author vikto
 */
public class CS102V08Zadatak4 {

    /**
     * @param args the command line arguments
     */
    private static List<CD> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new CD(new Autor(gerenateString(), gerenateString()), generateNumber(), gerenateString()));
        }
        Collections.sort(list, new CompareCD());
        System.out.println(list);
    }

    public static Autor searchForAutor(Autor a) {
        for (CD c : list) {
            if (c.getAutor().equals(a)) {
                return a;
            }
        }
        return null;
    }

}
