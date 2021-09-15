/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author vikto
 */
public class Telefon {

    private double cena;
    private double velicinaEkrana;
    private String model;
    private int kamera;

    public Telefon() {
    }

    public Telefon(double cena, double velicinaEkrana, String model, int kamera) {
        this.cena = cena;
        this.velicinaEkrana = velicinaEkrana;
        this.model = model;
        this.kamera = kamera;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKamera() {
        return kamera;
    }

    public void setKamera(int kamera) {
        this.kamera = kamera;
    }

    @Override
    public String toString() {
        return this.cena + "/n" + this.velicinaEkrana + "/n" + this.model + "/n" + this.kamera;

    }

}
