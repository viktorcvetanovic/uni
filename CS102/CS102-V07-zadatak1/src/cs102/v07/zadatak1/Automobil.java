/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v07.zadatak1;

/**
 *
 * @author vikto
 */
public class Automobil {

    private String marka;
    private String model;
    private int godiste;

    public Automobil() {
    }

    public Automobil(String marka, String model, int godiste) {
        this.marka = marka;
        this.model = model;
        this.godiste = godiste;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    @Override
    public String toString() {
        return "Automobil{" + "marka=" + marka + ", model=" + model + ", godiste=" + godiste + '}';
    }

}
