/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

/**
 *
 * @author vikto
 */
public class Proizvodjac {

    private String naziv;
    private int godProizvodnje;
    private String grad;
    private int brojProizvedenih;

    public Proizvodjac() {

    }

    public Proizvodjac(String naziv, int godProizvodnje, String grad, int brojProizvedenih) {
        this.naziv = naziv;
        this.godProizvodnje = godProizvodnje;
        this.grad = grad;
        this.brojProizvedenih = brojProizvedenih;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getGodProizvodnje() {
        return godProizvodnje;
    }

    public String getGrad() {
        return grad;
    }

    public int getBrojProizvedenih() {
        return brojProizvedenih;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setGodProizvodnje(int godProizvodnje) {
        this.godProizvodnje = godProizvodnje;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public void setBrojProizvedenih(int brojProizvedenih) {
        this.brojProizvedenih = brojProizvedenih;
    }

    @Override
    public String toString() {
        return "Proizvodjac{" + "naziv=" + naziv + ", godProizvodnje=" + godProizvodnje + ", grad=" + grad + ", brojProizvedenih=" + brojProizvedenih + '}';
    }

}
