/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v05.zadatak4;

/**
 *
 * @author vikto
 */
public class CS102V05Zadatak4 {

    private static int zbir = 0;

    public static void izracunajBrojeveNaNeparnimPozicijama(int broj) {

        if (broj == 0) {
            System.out.println(zbir);
        } else {
            zbir += broj % 10;
            izracunajBrojeveNaNeparnimPozicijama((broj / 10) / 10);
        }

    }

    public static void main(String[] args) {
        izracunajBrojeveNaNeparnimPozicijama(12121);
    }

}
