/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak11;

/**
 *
 * @author vikto
 */
public class Zaposleni {

    private Long indefikator;
    private String ime;
    private String prezime;
    private Integer godineStartosti;
    private String zvanje;

    public Zaposleni() {
    }

    public Zaposleni(Long indefikator, String ime, String prezime, Integer godineStartosti, String zvanje) {
        this.indefikator = indefikator;
        this.ime = ime;
        this.prezime = prezime;
        this.godineStartosti = godineStartosti;
        this.zvanje = zvanje;
    }

    public Long getIndefikator() {
        return indefikator;
    }

    public void setIndefikator(Long indefikator) {
        this.indefikator = indefikator;
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

    public Integer getGodineStartosti() {
        return godineStartosti;
    }

    public void setGodineStartosti(Integer godineStartosti) {
        this.godineStartosti = godineStartosti;
    }

    public String getZvanje() {
        return zvanje;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "indefikator=" + indefikator + ", ime=" + ime + ", prezime=" + prezime + ", godineStartosti=" + godineStartosti + ", zvanje=" + zvanje + '}';
    }

}
