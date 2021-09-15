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
public class Pas extends Zivotinja {

    public Pas(String ime, String rasa) {
        super(ime, rasa);
    }

    public Pas(Pas p) {
        super(p);
    }

    @Override
    public void oglasavanje() {
        System.out.println("AV AV");
    }

}
