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
public abstract class Kompjuter {

    private String cpu;
    private String memorija;
    private String grafika;
    private String napajanje;
    private String maticnaPloca;

    public Kompjuter(String cpu, String memorija, String grafika, String napajanje, String maticnaPloca) {
        this.cpu = cpu;
        this.memorija = memorija;
        this.grafika = grafika;
        this.napajanje = napajanje;
        this.maticnaPloca = maticnaPloca;
    }

    public Kompjuter() {
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemorija() {
        return memorija;
    }

    public void setMemorija(String memorija) {
        this.memorija = memorija;
    }

    public String getGrafika() {
        return grafika;
    }

    public void setGrafika(String grafika) {
        this.grafika = grafika;
    }

    public String getNapajanje() {
        return napajanje;
    }

    public void setNapajanje(String napajanje) {
        this.napajanje = napajanje;
    }

    public String getMaticnaPloca() {
        return maticnaPloca;
    }

    public void setMaticnaPloca(String maticnaPloca) {
        this.maticnaPloca = maticnaPloca;
    }

    @Override
    public String toString() {
        return "Kompjuter{" + "cpu=" + cpu + ", memorija=" + memorija + ", grafika=" + grafika + ", napajanje=" + napajanje + ", maticnaPloca=" + maticnaPloca + '}';
    }

    protected abstract double getCena();

}
