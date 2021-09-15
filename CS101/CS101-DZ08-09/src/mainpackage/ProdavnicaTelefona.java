/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author vikto
 */
public class ProdavnicaTelefona {

    private String adresa;
    private String grad;
    private String naziv;
    private Telefon niz[] = new Telefon[5];

    public ProdavnicaTelefona() {
    }

    public ProdavnicaTelefona(String adresa, String grad, String naziv, Telefon niz[]) {
        this.adresa = adresa;
        this.grad = grad;
        this.naziv = naziv;
        this.niz = niz;
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

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Telefon[] getNiz() {
        return niz;
    }

    public void setNiz(Telefon[] niz) {
        this.niz = niz;
    }

    @Override
    public String toString() {
        return "ProdavnicaTelefona{" + "adresa=" + adresa + ", grad=" + grad + ", naziv=" + naziv + ", niz=" + niz + '}';
    }

    public double cenaTelefonaSaNajboljomKamerom() {
        double minCena = 0;
        double bestCamera = 0;
        for (Telefon s : niz) {
            if (s.getKamera() > bestCamera) {
                minCena = s.getCena();
                bestCamera = s.getKamera();
            }
        }
        return minCena;

    }

}
