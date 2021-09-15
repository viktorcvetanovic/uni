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
public class Macka extends Zivotinja {

    public Macka(String ime, String rasa) {
        super(ime, rasa);
    }

    public Macka(Macka m) {
        super(m);
    }

    @Override
    public void oglasavanje() {
        System.out.println("MJAU MJAU");
    }

}
