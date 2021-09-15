/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07;

import java.util.Comparator;

/**
 *
 * @author Nikola
 */
public class RacunComparator  implements Comparator<Racun>{

    @Override
    public int compare(Racun o1, Racun o2) {
     return Integer.valueOf(o1.getAccountNumber()).compareTo(Integer.valueOf(o2.getAccountNumber()));
    }
    
}
