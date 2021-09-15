/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package3;

/**
 *
 * @author vikto
 */
public class CenaArazmana {

    private double arazman1;
    private double arazman2;
    private double arazman3;

    public CenaArazmana(double arazman1, double arazman2, double arazman3) {
        this.arazman1 = arazman1;
        this.arazman2 = arazman2;
        this.arazman3 = arazman3;
    }

    public double getArazman1() {
        return arazman1;
    }

    public void setArazman1(double arazman1) {
        this.arazman1 = arazman1;
    }

    public double getArazman2() {
        return arazman2;
    }

    public void setArazman2(double arazman2) {
        this.arazman2 = arazman2;
    }

    public double getArazman3() {
        return arazman3;
    }

    public void setArazman3(double arazman3) {
        this.arazman3 = arazman3;
    }

    @Override
    public String toString() {
        return "CenaArazmana{" + "arazman1=" + arazman1 + ", arazman2=" + arazman2 + ", arazman3=" + arazman3 + '}';
    }

}
