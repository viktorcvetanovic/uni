/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

/**
 *
 * @author vikto
 */
public class Automobil {

    private Proizvodjac proizvodjac;
    private String model;
    private int godiste;
    private double cena;
    private boolean registrovan;
    private Gorivo gorivo;

    public Automobil(Proizvodjac proizvodjac, String model, int godiste, double cena, boolean registrovan, Gorivo gorivo) {
        this.proizvodjac = proizvodjac;
        this.model = model;
        this.godiste = godiste;
        this.cena = cena;
        this.registrovan = registrovan;
        this.gorivo = gorivo;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public String getModel() {
        return model;
    }

    public int getGodiste() {
        return godiste;
    }

    public double getCena() {
        return cena;
    }

    public boolean isRegistrovan() {
        return registrovan;
    }

    public Gorivo getGorivo() {
        return gorivo;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setRegistrovan(boolean registrovan) {
        this.registrovan = registrovan;
    }

    public void setGorivo(Gorivo gorivo) {
        this.gorivo = gorivo;
    }

    @Override
    public String toString() {
        return "Automobil{" + "proizvodjac=" + proizvodjac + ", model=" + model + ", godiste=" + godiste + ", cena=" + cena + ", registrovan=" + registrovan + ", gorivo=" + gorivo + '}';
    }

}
