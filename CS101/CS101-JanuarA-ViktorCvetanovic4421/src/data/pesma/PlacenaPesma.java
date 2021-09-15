/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pesma;

import enums.TipPlacanja;
import enums.TipZanra;
import exceptions.InvalidVrednostException;
import static utils.Chekers.pozitivnaVrednost;

/**
 *
 * @author student
 */
public class PlacenaPesma extends Pesma implements Comparable<PlacenaPesma> {

    private double cena;
    private TipPlacanja tipPlacanja;

    public PlacenaPesma() {
    }

    public PlacenaPesma(double cena, TipPlacanja tipPlacanja, String naslov, String izvodjac, int godIzdavanja, int trajanje, TipZanra tipZanra) throws InvalidVrednostException {
        super(naslov, izvodjac, godIzdavanja, trajanje, tipZanra);
        setCena(cena);
        this.tipPlacanja = tipPlacanja;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) throws InvalidVrednostException {
        if (pozitivnaVrednost(cena)) {
            this.cena = cena;
        } else {
            throw new InvalidVrednostException("Cena ne sme biti u minusu");
        }

    }

    public TipPlacanja getTipPlacanja() {
        return tipPlacanja;
    }

    public void setTipPlacanja(TipPlacanja tipPlacanja) {
        this.tipPlacanja = tipPlacanja;
    }

    @Override
    public String toString() {
        return "PlacenaPesma{" + "cena=" + cena + ", tipPlacanja=" + tipPlacanja + '}';
    }

    @Override
    public int compareTo(PlacenaPesma o) {
        if (this.cena == o.getCena()) {
            return 0;
        } else if (this.cena > o.getCena()) {
            return 1;
        }
        return -1;
    }

    @Override
    public String upisZaFajl() {
        return this.getIzvodjac() + "-" + this.getNaslov() + "\n" + this.getGodIzdavanja() + "," + this.getTipZanra() + "\n" + this.getTrajanje() + "\n" + this.getCena() + "\n" + this.getTipPlacanja();
    }

}
