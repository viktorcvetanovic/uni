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
public abstract class Basic {

    private String firstName;
    private String lastName;
    private String jmbg;
    private int cardNum;
    private int flightNum;
    private int placeNum;

    public Basic() {
    }

    public Basic(String firstName, String lastName, String jmbg, int cardNum, int flightNum, int placeNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.cardNum = cardNum;
        this.flightNum = flightNum;
        this.placeNum = placeNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public int getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(int placeNum) {
        this.placeNum = placeNum;
    }

    @Override
    public String toString() {
        return "Basic{" + "firstName=" + firstName + ", lastName=" + lastName + ", jmbg=" + jmbg + ", cardNum=" + cardNum + ", flightNum=" + flightNum + ", placeNum=" + placeNum + '}';
    }
}
