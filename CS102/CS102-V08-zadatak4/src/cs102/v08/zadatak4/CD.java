/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v08.zadatak4;

/**
 *
 * @author vikto
 */
public class CD {

    private Autor autor;
    private int brojPesama;
    private String zanr;

    public CD() {
    }

    public CD(Autor autor, int brojPesama, String zanr) {
        this.autor = autor;
        this.brojPesama = brojPesama;
        this.zanr = zanr;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getBrojPesama() {
        return brojPesama;
    }

    public void setBrojPesama(int brojPesama) {
        this.brojPesama = brojPesama;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    @Override
    public String toString() {
        return "CD{" + "autor=" + autor + ", brojPesama=" + brojPesama + ", zanr=" + zanr + '}';
    }

}
