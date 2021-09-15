/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.automobil;

import Interfaces.Racun;
import data.automobil.garancija.Garancija;
import data.automobil.opema.Oprema;
import enums.TipAutomobila;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Automobil implements Racun, Serializable {

    private int brojVrata;
    private String naziv;
    private TipAutomobila tip;
    private static double cena = 10000;
    private List<Oprema> oprema = new ArrayList<Oprema>();
    private Garancija garancija;

    public Automobil() {

    }

    public Automobil(int brojVrata, String naziv, TipAutomobila tip, List<Oprema> oprema, Garancija garancija) {
        this.brojVrata = brojVrata;
        this.naziv = naziv;
        this.tip = tip;

        this.oprema = oprema;
        this.garancija = garancija;
    }

    public Automobil(int brojVrata, String naziv, TipAutomobila tip, Garancija garancija) {
        this.brojVrata = brojVrata;
        this.naziv = naziv;
        this.tip = tip;
        this.garancija = garancija;

    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public TipAutomobila getTip() {
        return tip;
    }

    public void setTip(TipAutomobila tip) {
        this.tip = tip;
    }

    public double getCena() {
        return cena;
    }

    public List<Oprema> getOprema() {
        return oprema;
    }

    public void setOprema(List<Oprema> oprema) {
        this.oprema = oprema;
    }

    public Garancija getGarancija() {
        return garancija;
    }

    public void setGarancija(Garancija garancija) {
        this.garancija = garancija;
    }

    @Override
    public String toString() {
        return "Automobil{" + "brojVrata=" + brojVrata + ", naziv=" + naziv + ", tip=" + tip + ", cena=" + cena + ", oprema=" + oprema + ", garancija=" + garancija + '}';
    }

    /**
     * sabira cenu sa cenom automobila i dodatnim cenama iz opreme i garancije
     *
     * @return cena vraca cenu
     */
    @Override
    public double izracunajCenu() {
        if (this.brojVrata > 4) {
            cena += 1000;
        } else {
            cena += 500;
        }
        if (tip.ordinal() == TipAutomobila.LIMUZINA.ordinal()) {
            cena += 1000;
        } else {
            cena += 500;
        }

        cena += this.garancija.dodatnaCena();
        for (Oprema s : oprema) {
            cena += s.dodatnaCena();
        }

        return cena;

    }

}
