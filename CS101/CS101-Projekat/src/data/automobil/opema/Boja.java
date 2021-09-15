/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.automobil.opema;

/**
 *
 * @author vikto
 */
public class Boja extends Oprema {

    private String boja;

    public Boja() {
    }

    public Boja(String boja) {
        this.boja = boja;
    }

    /**
     * racuna dodatnu cenu
     *
     * return 1000;
     */
    @Override

    public double dodatnaCena() {
        return 1000;
    }
}
