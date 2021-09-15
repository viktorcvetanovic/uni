/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions.korisnik;

/**
 *
 * @author vikto
 */
public class InvalidNameSurnameException extends InvalidKorisnikException {

    public InvalidNameSurnameException(String string) {
        super(string);
    }

}
