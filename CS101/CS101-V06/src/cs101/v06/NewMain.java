/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.v06;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author vikto
 */
public class NewMain {

    public static void parniNiz(int niz[]) {

        for (int i = 0; i < niz.length; i++) {
            niz[i] = i * 2;
        }

    }

    public static void main(String[] args) {
        int niz[] = new int[10];
        parniNiz(niz);
        System.out.println(Arrays.toString(niz));

    }

}
