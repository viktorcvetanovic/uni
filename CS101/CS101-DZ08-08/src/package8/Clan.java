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
public class Clan {

    private String ime;
    private String prezime;
    private TipClana tip;

    public Clan(String ime, String prezime, TipClana tip) {
        this.ime = ime;
        this.prezime = prezime;
        this.tip = tip;
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

    public TipClana getTip() {
        return tip;
    }

    public void setTip(TipClana tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return this.ime + this.prezime + this.tip;
    }

}
