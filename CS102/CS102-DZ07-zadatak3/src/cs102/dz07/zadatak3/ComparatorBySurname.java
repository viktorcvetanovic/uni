/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak3;

import java.util.Comparator;

public class ComparatorBySurname implements Comparator<Student> {

    @Override
    public int compare(Student t, Student t1) {
        return t.getPrezime().compareTo(t1.getPrezime());
    }

}
