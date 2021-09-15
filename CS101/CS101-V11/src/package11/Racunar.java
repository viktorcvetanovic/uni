/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package11;

/**
 *
 * @author vikto
 */
public class Racunar extends Proizvod implements Comparable<Racunar> {

    private RacunarTip tip;
    private double brzinaProcesora;
    private int ram;

    public Racunar() {
    }

    public Racunar(RacunarTip tip, double brzinaProcesora, int ram, String productName, String password, double productPrice, double kolicina) {
        super(productName, password, productPrice, kolicina);
        if (brzinaProcesora > 0 && ram > 0) {
            this.tip = tip;
            this.brzinaProcesora = brzinaProcesora;
            this.ram = ram;
        } else {
            System.out.println("Brzina procesora i rama moraju biti vece od 0");
        }

    }

    public Racunar(Racunar r) {
        super(r);
        this.tip = r.tip;
        this.brzinaProcesora = r.brzinaProcesora;
        this.ram = r.ram;
    }

    public RacunarTip getTip() {
        return tip;
    }

    public void setTip(RacunarTip tip) {
        this.tip = tip;
    }

    public double getBrzinaProcesora() {
        return brzinaProcesora;
    }

    public void setBrzinaProcesora(double brzinaProcesora) {
        if (brzinaProcesora > 0) {
            this.brzinaProcesora = brzinaProcesora;
        } else {
            System.out.println("Vrednost mora bici veca od 0");
        }
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram > 0) {
            this.ram = ram;
        } else {
            System.out.println("Vrednost mora bici veca od 0");
        }
    }

    @Override
    public String toString() {
        return "Racunar{" + "tip=" + tip + ", brzinaProcesora=" + brzinaProcesora + ", ram=" + ram + '}';
    }

    @Override
    public int compareTo(Racunar t) {
        if (this.brzinaProcesora == t.brzinaProcesora) {
            if (this.ram == t.ram) {
                return 0;
            } else if (this.ram > t.ram) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.brzinaProcesora > t.brzinaProcesora) {
            return 1;
        }
        return -1;
    }

}
