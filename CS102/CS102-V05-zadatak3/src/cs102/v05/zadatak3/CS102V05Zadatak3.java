/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v05.zadatak3;

/**
 *
 * @author vikto
 */
public class CS102V05Zadatak3 {

    public static boolean isParan(int broj) {

        if (broj >= 10) {
            return !isParan(broj / 10);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isParan(2000));
    }

}
