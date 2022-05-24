/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

/**
 *
 * @author BiG
 */
public class Vip extends Basic {

    private int menu;

    public Vip() {
    }

    public Vip(int menu, String firstName, String lastName, String jmbg, int cardNum, int flightNum, int placeNum) {
        super(firstName, lastName, jmbg, cardNum, flightNum, placeNum);
        this.menu = menu;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Vip{" + "menu=" + menu + '}';
    }

}
