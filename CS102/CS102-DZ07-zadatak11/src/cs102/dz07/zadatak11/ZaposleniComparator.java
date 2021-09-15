/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak11;

import java.util.Comparator;

/**
 *
 * @author vikto
 */
public class ZaposleniComparator implements Comparator<Zaposleni> {

    @Override
    public int compare(Zaposleni t, Zaposleni t1) {
        return t.getIndefikator().compareTo(t1.getIndefikator());
    }

}
