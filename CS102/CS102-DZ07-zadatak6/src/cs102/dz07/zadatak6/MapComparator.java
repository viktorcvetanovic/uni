/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak6;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vikto
 */
public class MapComparator implements Comparator<List<PolozenIspit>> {

    @Override
    public int compare(List<PolozenIspit> t, List<PolozenIspit> t1) {
        Integer first = 0;
        Integer second = 0;
        first = t.stream().map((p) -> p.getOcena()).reduce(first, Integer::sum);
        first /= t.size();
        second = t1.stream().map((p) -> p.getOcena()).reduce(second, Integer::sum);
        second /= t1.size();
        return first.compareTo(second);
    }

}
