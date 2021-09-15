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
public class Kvadar extends Oblik3D {

    private double stranicaA;
    private double stranicaB;
    private double stranicaC;

    public Kvadar() {
    }

    public Kvadar(double stanicaA, double stanicaB, double stanicaC) {
        this.stranicaA = stanicaA;
        this.stranicaB = stanicaB;
        this.stranicaC = stanicaC;
    }

    public double getStanicaA() {
        return stranicaA;
    }

    public void setStanicaA(double stanicaA) {
        this.stranicaA = stanicaA;
    }

    public double getStanicaB() {
        return stranicaB;
    }

    public void setStanicaB(double stanicaB) {
        this.stranicaB = stanicaB;
    }

    public double getStanicaC() {
        return stranicaC;
    }

    public void setStanicaC(double stanicaC) {
        this.stranicaC = stanicaC;
    }

    @Override
    public String toString() {
        return "Kvadar{" + "stanicaA=" + stranicaA + ", stanicaB=" + stranicaB + ", stanicaC=" + stranicaC + '}';
    }

    @Override
    public double racunajZapreminu() {
        return (stranicaA * stranicaB * stranicaC);
    }

    @Override
    public double racunajPovrsinu() {
        return 2 * (stranicaA * stranicaB + stranicaB * stranicaC + stranicaA * stranicaC);
    }

}
