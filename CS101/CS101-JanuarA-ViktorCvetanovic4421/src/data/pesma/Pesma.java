/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pesma;

import enums.TipZanra;
import exceptions.InvalidVrednostException;
import static utils.Chekers.*;

/**
 *
 * @author student
 */
public abstract class Pesma {

    private String naslov;
    private String izvodjac;
    private int godIzdavanja;
    private int trajanje;
    private TipZanra tipZanra;

    public Pesma() {
    }

    public Pesma(String naslov, String izvodjac, int godIzdavanja, int trajanje, TipZanra tipZanra) throws InvalidVrednostException {
        this.naslov = naslov;
        this.izvodjac = izvodjac;
        setGodIzdavanja(godIzdavanja);
        setTrajanje(trajanje);
        this.tipZanra = tipZanra;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getIzvodjac() {
        return izvodjac;
    }

    public void setIzvodjac(String izvodjac) {
        this.izvodjac = izvodjac;
    }

    public int getGodIzdavanja() {
        return godIzdavanja;
    }

    public void setGodIzdavanja(int godIzdavanja) throws InvalidVrednostException {
        if (proveravaGodinu(godIzdavanja)) {
            this.godIzdavanja = godIzdavanja;
        } else {
            throw new InvalidVrednostException("Uneli ste pogresnu godinu");
        }

    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) throws InvalidVrednostException {
        if (pozitivnaVrednost(trajanje)) {
            this.trajanje = trajanje;
        } else {
            throw new InvalidVrednostException("Uneli ste negativno trajanje pesme");
        }

    }

    public TipZanra getTipZanra() {
        return tipZanra;
    }

    public void setTipZanra(TipZanra tipZanra) {
        this.tipZanra = tipZanra;
    }

    @Override
    public String toString() {
        return "Pesma{" + "naslov=" + naslov + ", izvodjac=" + izvodjac + ", godIzdavanja=" + godIzdavanja + ", trajanje=" + trajanje + ", tip=" + tipZanra + '}';
    }

    public abstract String upisZaFajl();

}
