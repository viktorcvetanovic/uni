package entity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BiG
 */
@Named
@RequestScoped
public class Osoba {

    private int id;
    private String ime;
    private String prezime;
    private int indeks;
    private String nacinStudiranja;

    public Osoba() {
    }

    public Osoba(int id, String ime, String prezime, int indeks, String nacinStudiranja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.nacinStudiranja = nacinStudiranja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNacinStudiranja() {
        return nacinStudiranja;
    }

    public void setNacinStudiranja(String nacinStudiranja) {
        this.nacinStudiranja = nacinStudiranja;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return "Osoba{" + "ime=" + ime + ", prezime=" + prezime + '}';
    }

}
