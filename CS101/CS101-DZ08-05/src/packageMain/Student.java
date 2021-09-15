/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

/**
 *
 * @author vikto
 */
public class Student {

    private String ime;
    private String prezime;
    private int index;
    private TipStudenta tip;

    public Student(String ime, String prezime, int index, TipStudenta tip) {
        this.ime = ime;
        this.prezime = prezime;
        this.index = index;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TipStudenta getTip() {
        return tip;
    }

    public void setTip(TipStudenta tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", index=" + index + ", tip=" + tip + '}';
    }

}
