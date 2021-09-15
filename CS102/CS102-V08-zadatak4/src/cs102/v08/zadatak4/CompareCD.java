/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v08.zadatak4;

import java.util.Comparator;

/**
 *
 * @author vikto
 */
public class CompareCD implements Comparator<CD> {

    @Override
    public int compare(CD t, CD t1) {
        return t.getAutor().compareTo(t1.getAutor());
    }

}
