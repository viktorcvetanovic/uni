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
public class Lokomotiva extends ZeleznickoVozilo {

    private double vucnaSnaga;
    private double tezina;
    private String godinaProizvodnje;

    public Lokomotiva() {
    }

    public Lokomotiva(double vucnaSnaga, double tezina, String godinaProizvodnje, String IDbroj) {
        super(IDbroj);
        this.vucnaSnaga = vucnaSnaga;
        this.tezina = tezina;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public double getVucnaSnaga() {
        return vucnaSnaga;
    }

    public void setVucnaSnaga(double vucnaSnaga) {
        this.vucnaSnaga = vucnaSnaga;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public String getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(String godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    @Override
    public String toString() {
        return "Lokomotiva{" + "vucnaSnaga=" + vucnaSnaga + ", tezina=" + tezina + ", godinaProizvodnje=" + godinaProizvodnje + '}';
    }

}
