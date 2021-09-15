/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exepctions.GradNijeValidanException;
import exepctions.PostanskiBrojNijeValidanException;

/**
 *
 * @author vikto
 */
public class Posiljka {

    private String naziv;
    private double tezina;
    private String adresa;
    private String grad;
    private String postanskiBroj;
    private String brojTelefona;

    public Posiljka() {
    }

    public Posiljka(String naziv, double tezina, String adresa, String grad, String postanskiBroj, String brojTelefona) throws GradNijeValidanException, PostanskiBrojNijeValidanException {
        this.naziv = naziv;
        this.tezina = tezina;
        this.adresa = adresa;
        setGrad(grad);
        setPostanskiBroj(postanskiBroj);
        this.brojTelefona = brojTelefona;
    }

    public Posiljka(Posiljka p) {
        this.naziv = p.naziv;
        this.tezina = p.tezina;
        this.adresa = p.adresa;
        this.grad = p.grad;
        this.postanskiBroj = p.postanskiBroj;
        this.brojTelefona = p.brojTelefona;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {

        return grad;
    }

    public void setGrad(String grad) throws GradNijeValidanException {
        if (grad.length() > 2) {
            this.grad = grad;
        } else {
            throw new GradNijeValidanException("Grad mora biti duzi od 2");
        }

    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) throws PostanskiBrojNijeValidanException {
        if (postanskiBroj.length() == 5) {
            this.postanskiBroj = postanskiBroj;
        } else {
            throw new PostanskiBrojNijeValidanException("Vas broj " + postanskiBroj + " nije validan");
        }

    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return "Posiljka{" + "naziv=" + naziv + ", tezina=" + tezina + ", adresa=" + adresa + ", grad=" + grad + ", postanskiBroj=" + postanskiBroj + ", brojTelefona=" + brojTelefona + '}';
    }

}
