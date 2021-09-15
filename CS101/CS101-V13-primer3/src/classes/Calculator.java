/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.CalculatorException;
import exceptions.DeljenjeSaNulomException;
import exceptions.NegativanBrojException;

/**
 *
 * @author vikto
 */
public class Calculator {

    private double a;
    private double b;

    public Calculator() {
    }

    public Calculator(double a, double b) throws CalculatorException {
        setA(a);
        setB(b);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) throws CalculatorException {
        if (a > 0) {
            this.a = a;
        } else {
            throw new NegativanBrojException("Broj mora biti veci od 0");
        }
    }

    public double getB() {
        return b;
    }

    public void setB(double b) throws CalculatorException {
        if (b > 0) {
            this.b = b;
        } else if (b == 0) {
            throw new DeljenjeSaNulomException("Nemoguce je deliti sa 0");
        } else {
            throw new NegativanBrojException("Broj mora biti veci od 0");
        }
    }

    public double podeli() {
        return a / b;
    }

    @Override
    public String toString() {
        return "Calculator{" + "a=" + a + ", b=" + b + '}';
    }

}
