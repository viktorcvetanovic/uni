/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz04.zadatak1;

/**
 *
 * @author vikto
 */
public class CS102DZ04Zadatak1 {

    public static int izracunaj(int broj, int stepen) {
        if (stepen == 0) {
            return 1;
        }

        return (int) (Math.pow(broj, stepen) / stepen + izracunaj(broj, stepen - 1));
    }

    public static void main(String[] args) {
        System.out.println(izracunaj(4, 2));
    }

}
