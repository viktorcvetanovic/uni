/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author vikto
 */
public class Putnicki extends Vagon {

    private int maxPutnika;
    private double maxTezina;
    private int trenutnoPutnika;
    private double trenutnaTezina;

    public Putnicki(int maxPutnika, double maxTezina, int trenutnoPutnika, double trenutnaTezina, String proizvodjac, double tezina, String IDbroj) {
        super(proizvodjac, tezina, IDbroj);
        this.maxPutnika = maxPutnika;
        this.maxTezina = maxTezina;
        this.trenutnoPutnika = trenutnoPutnika;
        this.trenutnaTezina = trenutnaTezina;
    }

    public int getMaxPutnika() {
        return maxPutnika;
    }

    public void setMaxPutnika(int maxPutnika) {
        this.maxPutnika = maxPutnika;
    }

    public double getMaxTezina() {
        return maxTezina;
    }

    public void setMaxTezina(double maxTezina) {
        this.maxTezina = maxTezina;
    }

    public int getTrenutnoPutnika() {
        return trenutnoPutnika;
    }

    public void setTrenutnoPutnika(int trenutnoPutnika) {
        this.trenutnoPutnika = trenutnoPutnika;
    }

    public double getTrenutnaTezina() {
        return trenutnaTezina;
    }

    public void setTrenutnaTezina(double trenutnaTezina) {
        this.trenutnaTezina = trenutnaTezina;
    }

    @Override
    public String toString() {
        return "Putnicki{" + "maxPutnika=" + maxPutnika + ", maxTezina=" + maxTezina + ", trenutnoPutnika=" + trenutnoPutnika + ", trenutnaTezina=" + trenutnaTezina + '}';
    }

    @Override
    public double racunajNosivost() {
        return (this.getTezina() + (this.trenutnoPutnika * 80) + this.trenutnaTezina);
    }

}
