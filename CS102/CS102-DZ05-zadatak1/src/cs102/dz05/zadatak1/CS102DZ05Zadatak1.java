/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz05.zadatak1;

import static cs102.dz05.zadatak1.GenericUtil.*;
import java.util.ArrayList;
import java.util.List;

public class CS102DZ05Zadatak1 {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            b.add(i);
        }
        System.out.println(brisiElemente(a, b));
        System.out.println(sadrzi(b, 1));

    }

}
