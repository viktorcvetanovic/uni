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
public class VlasnikAgencije {

    private String ime;
    private String prezime;
    private String JBMG;
    private PolVlasnika pol;

    public VlasnikAgencije() {

    }

    public VlasnikAgencije(String ime, String prezime, String JBMG, PolVlasnika pol) {
        this.ime = ime;
        this.prezime = prezime;
        this.JBMG = JBMG;
        this.pol = pol;
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

    public String getJBMG() {
        return JBMG;
    }

    public void setJBMG(String JBMG) {
        this.JBMG = JBMG;
    }

    public PolVlasnika getPol() {
        return pol;
    }

    public void setPol(PolVlasnika pol) {
        this.pol = pol;
    }

    @Override
    public String toString() {
        return "VlasnikAgencije{" + "ime=" + ime + ", prezime=" + prezime + ", JBMG=" + JBMG + ", pol=" + pol + '}';
    }

}
