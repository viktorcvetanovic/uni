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
public abstract class Proizvod {

    private String productName;
    private String password;
    private double productPrice;
    private double kolicina;

    public Proizvod() {
    }

    public Proizvod(String productName, String password, double productPrice, double kolicina) {
        if (productPrice > 0) {

            this.productName = productName;
            this.password = password;
            this.productPrice = productPrice;
            this.kolicina = kolicina;
        } else {
            System.out.println("Cena mora biti veca od 0");
        }
    }

    public Proizvod(Proizvod r) {
        this.productName = r.productName;
        this.kolicina = r.kolicina;
        this.productPrice = r.productPrice;
        this.password = r.password;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

}
