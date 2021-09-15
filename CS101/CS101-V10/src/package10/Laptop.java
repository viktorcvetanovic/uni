/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package10;

/**
 *
 * @author vikto
 */
public class Laptop extends Kompjuter {

    private String baterija;

    public Laptop() {
    }

    public Laptop(String baterija, String cpu, String memorija, String grafika, String napajanje, String maticnaPloca) {
        super(cpu, memorija, grafika, napajanje, maticnaPloca);
        this.baterija = baterija;
    }

    public String getBaterija() {
        return baterija;
    }

    public void setBaterija(String baterija) {
        this.baterija = baterija;
    }

    @Override
    public double getCena() {
        return Math.random() * 4300 + 700;
    }

    @Override
    public String toString() {
        return super.toString() + "Laptop{" + "baterija=" + baterija + '}';
    }

}
