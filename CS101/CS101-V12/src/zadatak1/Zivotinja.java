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
public abstract class Zivotinja {

    private String ime;
    private String rasa;

    public Zivotinja() {
    }

    public Zivotinja(String ime, String rasa) {
        this.ime = ime;
        this.rasa = rasa;
    }

    public Zivotinja(Zivotinja z) {
        this.ime = z.ime;
        this.rasa = z.rasa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public abstract void oglasavanje();
}
