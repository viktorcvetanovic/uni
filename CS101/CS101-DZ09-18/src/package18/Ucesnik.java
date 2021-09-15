/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package18;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Ucesnik {

    private String ime;
    private String prezime;
    private int godineRodjenja;
    private String grad;
    private List<Pitanje> lista = new ArrayList<>();

    public Ucesnik() {
    }

    public Ucesnik(String ime, String prezime, int godineRodjenja, String grad, List<Pitanje> lista) {
        this.ime = ime;
        this.prezime = prezime;
        this.godineRodjenja = godineRodjenja;
        this.grad = grad;
        this.lista = lista;
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

    public int getGodineRodjenja() {
        return godineRodjenja;
    }

    public void setGodineRodjenja(int godineRodjenja) {
        this.godineRodjenja = godineRodjenja;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public List<Pitanje> getLista() {
        return lista;
    }

    public void setLista(List<Pitanje> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Ucesnik{" + "ime=" + ime + ", prezime=" + prezime + ", godineRodjenja=" + godineRodjenja + ", grad=" + grad + ", lista=" + lista + '}';
    }

    public double ukupnoPoena() {
        double poeni = 0;
        for (Pitanje p : lista) {
            if (p.getTacnost().ordinal() == OdgovorTacnost.TACNO.ordinal()) {
                poeni += p.getBrojBodova();
            }

        }
        return poeni;
    }

}
