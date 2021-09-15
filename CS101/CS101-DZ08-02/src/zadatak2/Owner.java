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
public class Owner {

    private String ownerName;
    private String ownerJMBG;
    private String ownerAdress;

    public Owner(String ownerName, String ownerJMBG, String ownerAdress) {
        this.ownerName = ownerName;

        this.ownerAdress = ownerAdress;
        if (ownerJMBG.length() == 13) {
            this.ownerJMBG = ownerJMBG;
        }
    }

    public void setOwnerAdress(String ownerAdress) {
        this.ownerAdress = ownerAdress;
    }

    public String getOwnerAdress() {
        return ownerAdress;
    }

    public Owner(String ownerName, String ownerJMBG) {
        this.ownerName = ownerName;

    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;

    }

    public void setOwnerJMBG(String OwnerJMBG) {
        if (ownerJMBG.length() == 13) {
            this.ownerJMBG = ownerJMBG;
        }
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getOwnerJMBG() {
        return this.ownerJMBG;
    }

    @Override
    public String toString() {
        return "Owner{" + "ownerName=" + ownerName + ", ownerJMBG=" + ownerJMBG + ", ownerAdress=" + ownerAdress + '}';
    }

}
