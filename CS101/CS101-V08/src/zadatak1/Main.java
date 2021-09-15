/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Proizvodjac p1 = new Proizvodjac("Audi", 2007, "Beograd", 10000);
        p1.setBrojProizvedenih(12000);
        Automobil a1 = new Automobil(p1, "a4", 2007, 25000, true, Gorivo.DIZEL);
        System.out.print(a1);
    }
    
}
