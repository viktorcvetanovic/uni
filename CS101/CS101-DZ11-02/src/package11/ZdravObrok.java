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
public class ZdravObrok extends Obrok {

    public ZdravObrok(double proteini, double uh, double masti) {
        super(proteini, uh, masti);
    }

    public ZdravObrok() {

    }

    public ZdravObrok(Obrok r) {
        super(r);
    }

    @Override
    public String toString() {
        return "Ovo su namernice za zdrav obrok" + (super.toString());
    }

    @Override
    public double racunajKalorije() {
        return (this.getProteini() * 3 + this.getUh() * 2 + this.getMasti() * 2);
    }

}
