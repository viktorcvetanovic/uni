/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v07.zadatak3;

/**
 *
 * @author vikto
 */
public class Pitanje {

    private String pitanje;
    private String odgovor;

    public Pitanje() {
    }

    public Pitanje(String pitanje, String odgovor) {
        this.pitanje = pitanje;
        this.odgovor = odgovor;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    @Override
    public String toString() {
        return "Pitanje{" + "pitanje=" + pitanje + ", odgovor=" + odgovor + '}';
    }

}
