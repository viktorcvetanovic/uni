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
public class Teretni extends Vagon {

    private double maxNosivost;
    private double trenutnaTezina;

    public Teretni() {
    }

    public Teretni(double maxNosivost, double trenutnaTezina, String proizvodjac, double tezina, String IDbroj) {
        super(proizvodjac, tezina, IDbroj);
        this.maxNosivost = maxNosivost;
        this.trenutnaTezina = trenutnaTezina;
    }

    public double getMaxNosivost() {
        return maxNosivost;
    }

    public void setMaxNosivost(double maxNosivost) {
        this.maxNosivost = maxNosivost;
    }

    public double getTrenutnaTezina() {
        return trenutnaTezina;
    }

    public void setTrenutnaTezina(double trenutnaTezina) {
        this.trenutnaTezina = trenutnaTezina;
    }

    @Override
    public String toString() {
        return "Teretni{" + "maxNosivost=" + maxNosivost + ", trenutnaTezina=" + trenutnaTezina + '}';
    }

    @Override
    public double racunajNosivost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
