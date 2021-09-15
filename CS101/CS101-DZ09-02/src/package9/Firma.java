/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Firma {

    private List<Isporuka> listIsporuka = new ArrayList<Isporuka>();

    @Override
    public String toString() {
        return "Firma{" + "listIsporuka=" + listIsporuka + '}';
    }

    public void addIsporuka(Isporuka isporuka) {
        listIsporuka.add(isporuka);
    }
}
