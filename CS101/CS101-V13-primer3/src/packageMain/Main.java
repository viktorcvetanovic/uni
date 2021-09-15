/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

import classes.Calculator;
import exceptions.CalculatorException;
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
            Calculator c = new Calculator(2, 2);
            System.out.println(c.podeli());
        } catch (CalculatorException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
