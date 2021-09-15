/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author student
 */
public class Chekers {

    public static boolean proveravaGodinu(int godina) {
        if (godina > 1900 && godina < 2021) {
            return true;
        }
        return false;
    }

    public static boolean pozitivnaVrednost(int broj) {
        if (broj >= 0) {
            return true;
        }
        return false;
    }

    public static boolean pozitivnaVrednost(double broj) {
        if (broj >= 0) {
            return true;
        }
        return false;
    }
}
