/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak6;

/**
 *
 * @author vikto
 */
public class PolozenIspit {

    private String oznaka;
    private Integer ocena;

    public PolozenIspit() {
    }

    public PolozenIspit(String oznaka, Integer ocena) {
        this.oznaka = oznaka;
        this.ocena = ocena;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "PolozenIspit{" + "oznaka=" + oznaka + ", ocena=" + ocena + '}';
    }

}
