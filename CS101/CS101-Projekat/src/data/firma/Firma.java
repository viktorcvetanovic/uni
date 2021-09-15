/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.firma;

import data.automobil.Automobil;
import data.korisnik.Korisnik;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Firma {

    private String naziv;
    private String lokacija;
    private String PIB;
    private Korisnik korisnik;
    private List<Automobil> lista = new ArrayList<>();

    public Firma() {
    }

    public Firma(String naziv, String lokacija, String PIB, Korisnik korisnik) {
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.PIB = PIB;
        this.korisnik = korisnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<Automobil> getLista() {
        return lista;
    }

    public void setLista(List<Automobil> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Firma{" + "naziv=" + naziv + ", lokacija=" + lokacija + ", PIB=" + PIB + ", korisnik=" + korisnik + ", lista=" + lista + '}';
    }

    /**
     * Prikazuje sve automobile
     *
     *
     */
    public void prikaziGotoveAutomobile() {
        System.out.println(lista);
    }

    /**
     * Vraca auto koji korisnik izabere
     *
     * @param a broj
     * @return a automobil koji je gotov
     */
    public Automobil prikaziGotovAuto(int a) {
        a = a - 1;
        return lista.get(a);
    }

}
