/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v05.zadatak2;

/**
 *
 * @author vikto
 */
public class CS102V05Zadatak2 {

    public static int okreniBroj(int broj) {
        if (broj == 0) {
            return 0;
        }
        int zadnjaCifra = broj % 10;
        return (int) (zadnjaCifra * Math.pow(10, String.valueOf(broj).length() - 1) + okreniBroj(broj / 10));
    }

    public static void main(String[] args) {
        System.out.println(okreniBroj(133));
    }

}
