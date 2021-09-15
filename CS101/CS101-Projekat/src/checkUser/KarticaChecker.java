/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkUser;

import data.korisnik.Kartica;

/**
 *
 * @author vikto
 */
public class KarticaChecker {

    /**
     * proverava validnost kartice
     *
     * @param kartica prima broj kartice
     * @return vraca true ili false
     */
    public static boolean proveriBrojKartice(String kartica) {
        boolean numeric = true;
        try {
            Double num = Double.parseDouble(kartica);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
    }

}
