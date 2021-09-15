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
public class MehanickiAlati extends Alati {

    private String rokUpotrebe;

    public MehanickiAlati(String rokUpotrebe, String ime, String serijskiBroj, double cena) {
        super(ime, serijskiBroj, cena);
        this.rokUpotrebe = rokUpotrebe;
    }

    public String getRokUpotrebe() {
        return rokUpotrebe;
    }

    public void setRokUpotrebe(String rokUpotrebe) {
        this.rokUpotrebe = rokUpotrebe;
    }

    @Override
    public String toString() {
        return super.toString() + "MehanickiAlati{" + "rokUpotrebe=" + rokUpotrebe + '}';
    }

}
