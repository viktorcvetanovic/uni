/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v05.zadatak5;

/**
 *
 * @author vikto
 */
public class CS102V05Zadatak5 {

    public static int NZD(int x, int y, int pom) {
        if (x % pom == 0 && y % pom == 0) {
            return pom;
        }
        return NZD(x, y, pom - 1);
    }

    public static void main(String[] args) {
        System.out.println(NZD(20, 10, Math.min(20, 10)));
    }

}
