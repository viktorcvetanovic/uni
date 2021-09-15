/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author vikto
 */
public abstract class ZeleznickoVozilo {

    private String IDbroj;

    public ZeleznickoVozilo() {
    }

    public ZeleznickoVozilo(String IDbroj) {
        this.IDbroj = IDbroj;
    }

    public String getIDbroj() {
        return IDbroj;
    }

    public void setIDbroj(String IDbroj) {
        this.IDbroj = IDbroj;
    }

    @Override
    public String toString() {
        return "ZeleznickoVozilo{" + "IDbroj=" + IDbroj + '}';
    }

}
