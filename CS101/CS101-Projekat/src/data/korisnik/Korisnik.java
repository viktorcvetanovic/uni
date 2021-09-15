/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.korisnik;

import static checkUser.LoginRegisterChecker.checkEmail;
import static checkUser.LoginRegisterChecker.checkIme;
import static checkUser.LoginRegisterChecker.checkPrezime;
import data.automobil.Automobil;
import exceptions.korisnik.InvalidEmailException;
import exceptions.korisnik.InvalidKorisnikException;
import exceptions.korisnik.InvalidNameSurnameException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Korisnik implements Serializable {

    private String ime;
    private String prezime;
    private String email;
    private String sifra;
    private Kartica kartica;
    private List<Automobil> automobil = new ArrayList<>();

    public Korisnik() {
    }

    public Korisnik(String ime, String prezime, String email, String sifra) throws InvalidKorisnikException {
        setIme(ime);
        setPrezime(prezime);
        setEmail(email);
        this.sifra = sifra;

    }

    public Korisnik(String ime, String prezime, String email, String sifra, Kartica kartica) throws InvalidKorisnikException {
        setIme(ime);
        setPrezime(prezime);
        setEmail(email);
        this.sifra = sifra;
        this.kartica = kartica;
    }

    public Korisnik(String ime, String prezime, String email, String sifra, Kartica kartica, List<Automobil> a) throws InvalidNameSurnameException, InvalidEmailException {
        setIme(ime);
        setPrezime(prezime);
        setEmail(email);
        this.sifra = sifra;
        this.kartica = kartica;
        automobil = a;
    }

    public Korisnik(Korisnik k) {
        this.ime = k.ime;
        this.prezime = k.prezime;
        this.email = k.email;
        this.sifra = k.sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) throws InvalidNameSurnameException {
        if (checkIme(ime)) {
            this.ime = ime;
        } else {
            throw new InvalidNameSurnameException("Pogresno ime ili prezime");
        }

    }

    public Kartica getKartica() {
        return kartica;
    }

    public void setKartica(Kartica kartica) {
        this.kartica = kartica;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) throws InvalidNameSurnameException {
        if (checkPrezime(prezime)) {
            this.prezime = prezime;
        } else {
            throw new InvalidNameSurnameException("Pogresno ime ili prezime");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (checkEmail(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("Pogresan mejl");
        }

    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", sifra=" + sifra + ", kartica=" + kartica + '}';
    }

    /**
     * metoda koja za svaki automobil dodat u listu racuna cenu i oduzima od
     * stanja na kartici
     *
     * return void
     */
    public void kupi() {
        double cena = 0;

        for (Automobil a : automobil) {
            cena += a.getCena();
        }
        if (kartica.getStanje() - cena >= 0) {
            System.out.println("Uspesno ste kupili automobile");
            kartica.setStanje(kartica.getStanje() - cena);
        } else {
            System.out.println("Nemate dovoljno novca");
        }
    }

    /**
     * dodaje automobil u listu
     *
     * @param a automobil koji unosimo
     *
     */
    public void dodajAuto(Automobil a) {
        automobil.add(a);
    }
}
