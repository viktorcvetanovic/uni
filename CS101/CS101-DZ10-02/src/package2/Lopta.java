/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

/**
 *
 * @author vikto
 */
public class Lopta extends Oblik3D {

    private double r;

    public Lopta() {
    }

    public Lopta(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Lopta{" + "r=" + r + '}';
    }

    @Override
    public double racunajPovrsinu() {
        return 4 * (r * r * Math.PI);
    }

    @Override
    public double racunajZapreminu() {
        return 4 / 3 * (r * r * r * Math.PI);
    }

}
