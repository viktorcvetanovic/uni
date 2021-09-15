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
public class ElektricniAlati extends Alati {

    private double snagaMotora;
    private double obrtniMoment;

    public ElektricniAlati(double snagaMotora, double obrtniMoment, String ime, String serijskiBroj, double cena) {
        super(ime, serijskiBroj, cena);
        this.snagaMotora = snagaMotora;
        this.obrtniMoment = obrtniMoment;

    }

    public double getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(double snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public double getObrtniMoment() {
        return obrtniMoment;
    }

    public void setObrtniMoment(double obrtniMoment) {
        this.obrtniMoment = obrtniMoment;
    }

    @Override
    public String toString() {
        return super.toString() + "ElektricniAlati{" + "snagaMotora=" + snagaMotora + ", obrtniMoment=" + obrtniMoment + '}';
    }

}
