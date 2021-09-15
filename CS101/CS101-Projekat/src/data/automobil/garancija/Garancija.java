/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.automobil.garancija;

/**
 *
 * @author vikto
 */
public class Garancija {

    private int duzina;
    private int maxVrednost;

    public Garancija() {
    }

    public Garancija(int duzina, int maxVrednost) {
        this.duzina = duzina;
        this.maxVrednost = maxVrednost;
    }

    public int getDuzina() {
        return duzina;
    }

    public void setDuzina(int duzina) {
        this.duzina = duzina;
    }

    public int getMaxVrednost() {
        return maxVrednost;
    }

    public void setMaxVrednost(int maxVrednost) {
        this.maxVrednost = maxVrednost;
    }

    /**
     * racuna dodatnu cenu
     *
     * @return cena
     */
    public double dodatnaCena() {
        double cena = 0;
        if (duzina > 5) {
            cena += 1000;
        } else if (maxVrednost > 5) {
            cena += 1000;
        } else {
            cena += 1000;
        }

        return cena;
    }

    @Override
    public String toString() {
        return "Garancija{" + "duzina=" + duzina + ", maxVrednost=" + maxVrednost + '}';
    }

}
