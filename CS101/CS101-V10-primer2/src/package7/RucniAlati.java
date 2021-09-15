/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package7;

/**
 *
 * @author vikto
 */
public class RucniAlati extends Alati {

    private int minimalneGodine;

    public RucniAlati(int minimalneGodine, String ime, String serijskiBroj, double cena) {
        super(ime, serijskiBroj, cena);
        this.minimalneGodine = minimalneGodine;
    }

    public int getMinimalneGodine() {
        return minimalneGodine;
    }

    public void setMinimalneGodine(int minimalneGodine) {
        this.minimalneGodine = minimalneGodine;
    }

    @Override
    public String toString() {
        return super.toString() + "RucniAlati{" + "minimalneGodine=" + minimalneGodine + '}';
    }

}
