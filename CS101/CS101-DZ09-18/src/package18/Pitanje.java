/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package18;

/**
 *
 * @author vikto
 */
public class Pitanje {

    private int sifra;
    private double brojBodova;
    private OdgovorTacnost tacnost;

    public Pitanje() {
    }

    public Pitanje(int sifra, double brojBodova, OdgovorTacnost tacnost) {
        this.sifra = sifra;
        this.brojBodova = brojBodova;
        this.tacnost = tacnost;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public double getBrojBodova() {
        return brojBodova;
    }

    public void setBrojBodova(double brojBodova) {
        this.brojBodova = brojBodova;
    }

    public OdgovorTacnost getTacnost() {
        return tacnost;
    }

    public void setTacnost(OdgovorTacnost tacnost) {
        this.tacnost = tacnost;
    }

    @Override
    public String toString() {
        return "Pitanje{" + "sifra=" + sifra + ", brojBodova=" + brojBodova + ", tacnost=" + tacnost + '}';
    }

}
