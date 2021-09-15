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
public class NezdravObrok extends Obrok {

    public NezdravObrok() {
    }

    public NezdravObrok(double proteini, double uh, double masti) {
        super(proteini, uh, masti);
    }

    public NezdravObrok(Obrok r) {
        super(r);
    }

    @Override
    public String toString() {
        return "Ovo su namernice za nezdrav obrok" + (super.toString());
    }

    @Override
    public double racunajKalorije() {
        return (super.getProteini() * 2 + super.getUh() * 5 + super.getMasti() * 5);
    }

}
