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
public class Desktop extends Kompjuter {

    private String kuciste;

    public Desktop() {
    }

    public Desktop(String kuciste, String cpu, String memorija, String grafika, String napajanje, String maticnaPloca) {
        super(cpu, memorija, grafika, napajanje, maticnaPloca);
        this.kuciste = kuciste;
    }

    @Override
    public String toString() {
        return super.toString() + "Desktop{" + "kuciste=" + kuciste + '}';
    }

    @Override
    public double getCena() {
        return Math.random() * 4700 + 300;
    }

}
