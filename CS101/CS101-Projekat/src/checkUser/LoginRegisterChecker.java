/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkUser;

/**
 *
 * @author vikto
 */
public class LoginRegisterChecker {

    /**
     * proverava validaciju korisnickog imena
     *
     * @param ime uzima ime
     * @return boolean vraca true ili false
     */
    public static boolean checkIme(String ime) {
        if (ime.length() > 3 && !ime.contains(" ")) {
            return true;
        }
        return false;
    }

    /**
     * proverava validaciju korisnickog prezimena
     *
     * @param prezime prima prezime
     * @return boolean vraca true ili false
     */
    public static boolean checkPrezime(String prezime) {
        if (prezime.length() > 4 && !prezime.contains(" ")) {
            return true;
        }
        return false;
    }

    /**
     * proverava validaciju korisnickog emaila
     *
     * @param email prima email
     * @return boolean vraca true ili false
     */
    public static boolean checkEmail(String email) {
        if (email.contains(".") && email.contains("@")) {
            return true;
        }
        return false;
    }

}
