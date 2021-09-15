/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v06.zadatak4;

/**
 *
 * @author vikto
 */
public class CS102V06Zadatak4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(simetrican(1, 1, 1, 1, 1));
    }

    public static <T> boolean simetrican(T... niz) {
        int l = niz.length;
        for (int i = 0; i < l; i++) {
            if (niz[i] != niz[l - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
