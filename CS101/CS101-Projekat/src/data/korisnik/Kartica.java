/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.korisnik;

import static checkUser.KarticaChecker.proveriBrojKartice;
import enums.TipKartice;
import exceptions.kartica.InvalidKartica;
import java.io.Serializable;

/**
 *
 * @author vikto
 */
public class Kartica implements Serializable {

    private String brojKartice;
    private double stanje;
    private TipKartice tip;

    public Kartica() {
    }

    public Kartica(String brojKartice, double stanje, TipKartice tip) {
        this.brojKartice = brojKartice;
        this.stanje = stanje;
        this.tip = tip;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) throws InvalidKartica {
        if (proveriBrojKartice(brojKartice)) {
            this.brojKartice = brojKartice;
        } else {
            throw new InvalidKartica("Pogresan broj kartice");
        }

    }

    public double getStanje() {
        return stanje;
    }

    public void setStanje(double stanje) {
        this.stanje = stanje;
    }

    public TipKartice getTip() {
        return tip;
    }

    public void setTip(TipKartice tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Kartica{" + "brojKartice=" + brojKartice + ", stanje=" + stanje + ", tip=" + tip + '}';
    }

}
