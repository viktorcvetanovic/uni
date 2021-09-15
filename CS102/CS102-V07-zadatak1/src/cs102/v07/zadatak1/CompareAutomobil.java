/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v07.zadatak1;

import java.util.Comparator;

/**
 *
 * @author vikto
 */
public class CompareAutomobil implements Comparator<Automobil> {

    @Override
    public int compare(Automobil t, Automobil t1) {
        return Integer.valueOf(t.getGodiste()).compareTo(t1.getGodiste());
    }

}
