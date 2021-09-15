/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz03.zadatak7;

/**
 *
 * @author vikto
 */
public class IzborPoteza {

    private String name;
    private String photo;
    private int brojPoteza;

    public IzborPoteza() {
    }

    public IzborPoteza(String name, String photo, int brojPoteza) {
        this.name = name;
        this.photo = photo;
        this.brojPoteza = brojPoteza;
    }

    public int getBrojPoteza() {
        return brojPoteza;
    }

    public void setBrojPoteza(int brojPoteza) {
        this.brojPoteza = brojPoteza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return name;
    }

}
