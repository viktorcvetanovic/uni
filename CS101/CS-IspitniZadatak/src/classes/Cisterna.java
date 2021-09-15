/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import enums.TipTecnosti;

/**
 *
 * @author vikto
 */
public class Cisterna extends Vagon {

    private double maxTecnost;
    private double trenutnaTecnost;
    private TipTecnosti tip;

    public Cisterna() {
    }

    public Cisterna(double maxTecnost, double trenutnaTecnost, TipTecnosti tip, String proizvodjac, double tezina, String IDbroj) {
        super(proizvodjac, tezina, IDbroj);
        this.maxTecnost = maxTecnost;
        this.trenutnaTecnost = trenutnaTecnost;
        this.tip = tip;
    }

    public double getMaxTecnost() {
        return maxTecnost;
    }

    public void setMaxTecnost(double maxTecnost) {
        this.maxTecnost = maxTecnost;
    }

    public double getTrenutnaTecnost() {
        return trenutnaTecnost;
    }

    public void setTrenutnaTecnost(double trenutnaTecnost) {
        this.trenutnaTecnost = trenutnaTecnost;
    }

    public TipTecnosti getTip() {
        return tip;
    }

    public void setTip(TipTecnosti tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Cisterna{" + "maxTecnost=" + maxTecnost + ", trenutnaTecnost=" + trenutnaTecnost + ", tip=" + tip + '}';
    }

    @Override
    public double racunajNosivost() {
        return 0;
    }

}
