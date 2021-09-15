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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Owner o1 = new Owner("Viktor", "Cvetanovic", "123456789101");
        Firma f1 = new Firma("Viktorova firma", "Somborska", 123, o1, 1500, 20, 100);
        Firma f2 = new Firma("Viktorova firma", "Somborska", 123, o1, 3000, 20, 100);
        System.out.println(f1.calculateBill());
        System.out.println(f2.calculateBill());

    }

}
