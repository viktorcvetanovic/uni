/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v08.zadatak4;

/**
 *
 * @author vikto
 */
public class Util {

    public static String gerenateString() {
        String s = "";
        for (int i = 0; i < 5; i++) {
            int randomNumber = (int) (Math.random() * 26 + 'a');
            s += (char) randomNumber;
        }
        return s;
    }

    public static int generateNumber() {
        return (int) (Math.random() * 25 + 1);
    }

}
