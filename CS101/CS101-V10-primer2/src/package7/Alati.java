/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package7;

/**
 *
 * @author vikto
 */
public abstract class Alati {

    private String ime;
    private String serijskiBroj;
    private double cena;

    public Alati(String ime, String serijskiBroj, double cena) {
        this.ime = ime;
        this.serijskiBroj = serijskiBroj;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(String serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Alati{" + "ime=" + ime + ", serijskiBroj=" + serijskiBroj + ", cena=" + cena + '}';
    }

}
