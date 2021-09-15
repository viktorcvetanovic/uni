/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package9;

/**
 *
 * @author vikto
 */
public class Prozor {

    private double debljina;
    private double visina;
    private double sirina;
    private double windowPrice;

    public Prozor(double debljina, double visina, double sirina, double windowPrice) {
        this.debljina = debljina;
        this.visina = visina;
        this.sirina = sirina;
        this.windowPrice = windowPrice;
    }

    public double getDebljina() {
        return debljina;
    }

    public void setDebljina(double debljina) {
        this.debljina = debljina;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public double getSirina() {
        return sirina;
    }

    public void setSirina(double sirina) {
        this.sirina = sirina;
    }

    public double getWindowPrice() {
        return windowPrice;
    }

    public void setWindowPrice(double windowPrice) {
        this.windowPrice = windowPrice;
    }

    @Override
    public String toString() {
        return "Prozor{" + "debljina=" + debljina + ", visina=" + visina + ", sirina=" + sirina + ", windowPrice=" + windowPrice + '}';
    }

}
