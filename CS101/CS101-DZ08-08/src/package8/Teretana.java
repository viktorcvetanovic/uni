/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package8;

/**
 *
 * @author vikto
 */
public class Teretana {

    private String naziv;
    private String adresa;
    private String PIB;
    private double cenaClanarine;
    private Clan niz[] = new Clan[15];

    public Teretana(String naziv, String adresa, String PIB, double cenaClanarine, Clan niz[]) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.PIB = PIB;
        this.cenaClanarine = cenaClanarine;
        this.niz = niz;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public double getCenaClanarine() {
        return cenaClanarine;
    }

    public void setCenaClanarine(double cenaClanarine) {
        this.cenaClanarine = cenaClanarine;
    }

    public Clan[] getNiz() {
        return niz;
    }

    public void setNiz(Clan[] niz) {
        this.niz = niz;
    }

    @Override
    public String toString() {
        return "Teretana{" + "naziv=" + naziv + ", adresa=" + adresa + ", PIB=" + PIB + ", cenaClanarine=" + cenaClanarine + ", niz=" + niz + '}';
    }

    public double zaradaTeretane() {
        double zarada = 0;
        for (Clan c : this.niz) {
            if (c.getTip().ordinal() == TipClana.REDOVNICLAN.ordinal()) {
                zarada += (this.cenaClanarine - (this.cenaClanarine / 100.0 * 10));
            } else {
                zarada += this.cenaClanarine;
            }
        }
        return zarada;
    }
}
