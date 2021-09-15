/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package6;

/**
 *
 * @author vikto
 */
public class Zaposleni {

    private String name;
    private String surname;
    private double payment;
    private TipRadnika tip;

    public Zaposleni() {

    }

    public Zaposleni(String name, String surname, double payment, TipRadnika tip) {
        this.name = name;
        this.surname = surname;
        this.payment = payment;
        this.tip = tip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public TipRadnika getTip() {
        return tip;
    }

    public void setTip(TipRadnika tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "name=" + name + ", surname=" + surname + ", payment=" + payment + ", tip=" + tip + '}';
    }

}
