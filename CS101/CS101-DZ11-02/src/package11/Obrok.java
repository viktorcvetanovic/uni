/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package11;

/**
 *
 * @author vikto
 */
public abstract class Obrok implements Kalorican {

    private double proteini;
    private double uh;
    private double masti;

    public Obrok() {
    }

    public Obrok(double proteini, double uh, double masti) {
        this.proteini = proteini;
        this.uh = uh;
        this.masti = masti;
    }

    public Obrok(Obrok r) {
        this.masti = r.masti;
        this.proteini = r.proteini;
        this.uh = r.uh;
    }

    public double getProteini() {
        return proteini;
    }

    public void setProteini(double proteini) {
        this.proteini = proteini;
    }

    public double getUh() {
        return uh;
    }

    public void setUh(double uh) {
        this.uh = uh;
    }

    public double getMasti() {
        return masti;
    }

    public void setMasti(double masti) {
        this.masti = masti;
    }

    @Override
    public String toString() {
        return "Obrok{" + "proteini=" + proteini + ", uh=" + uh + ", masti=" + masti + '}';
    }

}
