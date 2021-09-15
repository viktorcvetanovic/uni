/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pesma;

import enums.TipZanra;
import enums.TipZvuka;
import exceptions.InvalidVrednostException;

/**
 *
 * @author student
 */
public class BesplatnaPesma extends Pesma implements Comparable<BesplatnaPesma> {

    private boolean celaPesma;
    private TipZvuka tipZvuka;

    public BesplatnaPesma() {
    }

    public BesplatnaPesma(boolean celaPesma, TipZvuka tipZvuka, String naslov, String izvodjac, int godIzdavanja, int trajanje, TipZanra tipZanra) throws InvalidVrednostException {
        super(naslov, izvodjac, godIzdavanja, trajanje, tipZanra);
        this.celaPesma = celaPesma;
        this.tipZvuka = tipZvuka;
    }

    public boolean isCelaPesma() {
        return celaPesma;
    }

    public void setCelaPesma(boolean celaPesma) {
        this.celaPesma = celaPesma;
    }

    public TipZvuka getTipZvuka() {
        return tipZvuka;
    }

    public void setTipZvuka(TipZvuka tipZvuka) {
        this.tipZvuka = tipZvuka;
    }

    @Override
    public String toString() {
        return "BesplatnaPesma{" + "celaPesma=" + celaPesma + ", tipZvuka=" + tipZvuka + '}';
    }

    @Override
    public int compareTo(BesplatnaPesma o) {
        if (this.getTrajanje() == o.getTrajanje()) {
            return 0;
        } else if (this.getTrajanje() > o.getTrajanje()) {
            return 1;
        }
        return -1;
    }

    public String upisZaFajl() {
        String cela;
        if (celaPesma) {
            cela = "FULL";
        } else {
            cela = "Preview";
        }

        return this.getIzvodjac() + "-" + this.getNaslov() + "\n" + this.getGodIzdavanja() + "," + this.getTipZanra() + "\n" + this.getTrajanje() + "\n" + cela + "\n" + this.getTipZvuka();
    }

}
