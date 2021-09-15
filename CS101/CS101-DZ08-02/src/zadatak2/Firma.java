/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

/**
 *
 * @author vikto
 */
public class Firma {

    private String name;
    private String adress;
    private int PIB;
    private Owner headOwner;
    private double mainBill;
    private int employes;
    private double employesBill;

    public Firma() {

    }

    public Firma(String name, String adress, int PIB, Owner headOwner, double mainBill, int employes, double employesBill) {
        this.name = name;
        this.adress = adress;
        this.PIB = PIB;
        this.headOwner = headOwner;
        this.mainBill = mainBill;
        this.employes = employes;
        this.employesBill = employesBill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPIB() {
        return PIB;
    }

    public void setPIB(int PIB) {
        this.PIB = PIB;
    }

    public Owner getHeadOwner() {
        return headOwner;
    }

    public void setHeadOwner(Owner headOwner) {
        this.headOwner = headOwner;
    }

    public double getMainBill() {
        return mainBill;
    }

    public void setMainBill(double mainBill) {
        this.mainBill = mainBill;
    }

    public int getEmployes() {
        return employes;
    }

    public void setEmployes(int employes) {
        this.employes = employes;
    }

    public double getEmployesBill() {
        return employesBill;
    }

    public void setEmployesBill(double employesBill) {
        this.employesBill = employesBill;
    }

    @Override
    public String toString() {
        return "Firma{" + "name=" + name + ", adress=" + adress + ", PIB=" + PIB + ", headOwner=" + headOwner + ", mainBill=" + mainBill + ", employes=" + employes + ", employesBill=" + employesBill + '}';
    }

    public boolean calculateBill() {
        double money;
        money = this.mainBill - (this.employes * this.employesBill);
        if (money >= 0) {
            return true;
        }
        return false;
    }

}
