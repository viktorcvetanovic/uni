/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercation;

import classes.Posiljka;
import exepctions.GradNijeValidanException;
import exepctions.PosiljkaExceptions;
import exepctions.PostanskiBrojNijeValidanException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Posiljka p1 = new Posiljka("naziv", 200, "Somborska", "sss", "1235", "12412421");

        } catch (PosiljkaExceptions ex) {
            System.err.print(ex.getMessage());

        }
    }
}
