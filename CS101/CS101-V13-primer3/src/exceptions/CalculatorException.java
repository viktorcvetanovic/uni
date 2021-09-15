/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author vikto
 */
public abstract class CalculatorException extends Exception {

    public CalculatorException(String string) {
        super(string);
    }

}
