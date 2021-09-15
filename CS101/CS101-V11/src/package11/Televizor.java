/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package11;

/**
 *
 * @author vikto
 */
public class Televizor extends Proizvod implements Comparable<Televizor> {

    private TelevizorTip tip;
    private double dijagonala;

    public Televizor() {
    }

    public Televizor(TelevizorTip tip, double dijagonala, String productName, String password, double productPrice, double kolicina) {
        super(productName, password, productPrice, kolicina);
        if (dijagonala > 0) {
            this.tip = tip;
            this.dijagonala = dijagonala;
        } else {
            System.out.println("Dijagonala TV mora biti veca od 0");

        }

    }

    public Televizor(Televizor t) {
        super(t);
        this.tip = t.tip;
        this.dijagonala = t.dijagonala;
    }

    public TelevizorTip getTip() {
        return tip;
    }

    public void setTip(TelevizorTip tip) {
        this.tip = tip;
    }

    public double getDijagonala() {
        return dijagonala;
    }

    public void setDijagonala(double dijagonala) {
        if (dijagonala > 0) {
            this.dijagonala = dijagonala;
        } else {
            System.out.println("Vrednost mora biti veca od 0");
        }
    }

    @Override
    public String toString() {
        return "Televizor{" + "tip=" + tip + ", dijagonala=" + dijagonala + '}';
    }

    @Override
    public int compareTo(Televizor t) {
        if (this.dijagonala == t.dijagonala) {
            return 0;
        } else if (this.dijagonala > t.dijagonala) {
            return 1;
        }
        return -1;
    }

}
