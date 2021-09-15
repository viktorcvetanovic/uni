/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package3;

/**
 *
 * @author vikto
 */
public class TuristickaAgencija {

    private String naziv;
    private String grad;
    private String drzava;
    private CenaArazmana arazman;
    private VlasnikAgencije vlasnik;

    public TuristickaAgencija(String naziv, String grad, String drzava, CenaArazmana arazman, VlasnikAgencije vlasnik) {
        this.naziv = naziv;
        this.grad = grad;
        this.drzava = drzava;
        this.arazman = arazman;
        this.vlasnik = vlasnik;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return this.grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return this.drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public CenaArazmana getArazman() {
        return this.arazman;
    }

    public void setArazman(CenaArazmana arazman) {
        this.arazman = arazman;
    }

    public VlasnikAgencije getVlasnik() {
        return this.vlasnik;
    }

    public void setVlasnik(VlasnikAgencije vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public String toString() {
        return "TuristickaAgencija{" + "naziv=" + naziv + ", grad=" + grad + ", drzava=" + drzava + ", arazman=" + arazman + ", vlasnik=" + vlasnik + '}';
    }

    public void prosecnaCena() {
        System.out.println((this.arazman.getArazman1() + this.arazman.getArazman2() + this.arazman.getArazman3()) / 3);
    }
}
