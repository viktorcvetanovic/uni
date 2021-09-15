/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author vikto
 */
public abstract class Vagon extends ZeleznickoVozilo {

    private String proizvodjac;
    private double tezina;

    public Vagon() {
    }

    public Vagon(String proizvodjac, double tezina, String IDbroj) {
        super(IDbroj);
        this.proizvodjac = proizvodjac;
        this.tezina = tezina;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    @Override
    public String toString() {
        return "Vagon{" + "proizvodjac=" + proizvodjac + ", tezina=" + tezina + '}';
    }

    public abstract double racunajNosivost();
}
