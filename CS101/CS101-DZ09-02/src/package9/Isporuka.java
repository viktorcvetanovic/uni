/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Isporuka {

    private String adress;
    private double price;
    private List<Prozor> listProzor = new ArrayList<Prozor>();

    public Isporuka(String adress, double price, List<Prozor> listProzor) {
        this.adress = adress;
        this.price = price;
        this.listProzor = listProzor;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Prozor> getListProzor() {
        return listProzor;
    }

    public void setListProzor(List<Prozor> listProzor) {
        this.listProzor = listProzor;
    }

    public void addProzor(Prozor p1) {
        listProzor.add(p1);
    }

    @Override
    public String toString() {
        return "Isporuka{" + "adress=" + adress + ", price=" + price + ", listProzor=" + listProzor + '}';
    }

    public void priceUpdater() {

        for (Prozor p1 : this.listProzor) {
            this.price += p1.getWindowPrice();
        }
    }
}
