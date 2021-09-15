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
public class Svetla extends Oprema {

    private String svetla;

    public Svetla() {
    }

    public Svetla(String svetla) {
        this.svetla = svetla;
    }

    /**
     * racuna dodatnu cenu
     *
     * @return 1000;
     */
    @Override
    public double dodatnaCena() {
        return 1000;
    }

}
