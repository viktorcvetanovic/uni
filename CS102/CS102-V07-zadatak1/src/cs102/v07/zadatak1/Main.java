/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v07.zadatak1;

import static cs102.v07.zadatak1.Util.generateNumber;
import static cs102.v07.zadatak1.Util.gerenateString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Automobil> automobili = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            automobili.add(new Automobil(gerenateString(), gerenateString(), generateNumber()));
        }
        Collections.sort(automobili, new CompareAutomobil());
        System.out.println(automobili);
        Iterator<Automobil> it = automobili.iterator();
        ListIterator<Automobil> listIt = automobili.listIterator(automobili.size());
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }

    }

}
