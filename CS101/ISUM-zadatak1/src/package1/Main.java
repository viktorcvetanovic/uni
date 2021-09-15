/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author vikto
 */
public class Main {

    public static int[] vratiNiz() {
        int niz[];
        Date today = new Date();
        niz = new int[10];

        if (today.getDate() > 0) {
            niz = new int[today.getDate()];
        }

        for (int i = 0; i < niz.length; i++) {
            niz[i] = (int) (Math.random() * (today.getDay() + today.getMonth() - 1) + 1);
        }

        return niz;
    }

    public static int[] neparniIndeksNiz(int[] niz) {
        int[] drugiNiz = new int[niz.length / 2];
        int count = 0;
        for (int i = 1; i < niz.length; i += 2) {
            drugiNiz[count] = niz[i];
            count++;
        }
        return drugiNiz;
    }

    public static int[] parniIndeksNiz(int[] niz) {
        int[] treciNiz = new int[niz.length / 2];
        int count = 0;
        int duzina = 0;
        if (niz.length % 2 == 0) {
            duzina = niz.length;
        } else {
            duzina = niz.length - 1;
        }
        for (int i = 0; i < duzina - 1; i += 2) {
            treciNiz[count] = Math.round(niz[i] / 2);
            count++;
        }
        return treciNiz;
    }

    public static int[] saberiNiz(int[] nizA, int[] nizB) {
        int count = 0;
        int[] niz = new int[0];
        int lastElement = nizB.length - 1;
        int lastElementA = nizA.length - 1;
        if (nizA.length == nizB.length) {
            niz = new int[nizA.length];

            for (int i = 0; i < nizA.length; i++) {
                niz[count] = nizA[i] + nizB[lastElement - i];
                count++;
            }

        } else if (nizA.length > nizB.length) {
            niz = new int[nizA.length];
            for (int i = 0; i < nizA.length; i++) {

                if (i >= nizB.length) {
                    niz[count] = nizA[i];
                } else {
                    niz[count] = nizA[i] + nizB[lastElement - i];
                }
                count++;
            }

        } else {
            niz = new int[nizB.length];
            for (int i = 0; i < nizB.length; i++) {

                if (i >= nizA.length) {
                    niz[count] = nizB[lastElementA - i];
                } else {
                    niz[count] = nizA[i] + nizB[lastElementA - i];
                }
            }
        }

        return niz;
    }

    public static void main(String[] args) {

        int[] prviNiz = vratiNiz();
        System.out.println(Arrays.toString(prviNiz));
        int[] drugiNiz = neparniIndeksNiz(prviNiz);
        System.out.println(Arrays.toString(drugiNiz));
        int[] treciNiz = parniIndeksNiz(prviNiz);
        System.out.println(Arrays.toString(treciNiz));
        System.out.println(Arrays.toString(saberiNiz(prviNiz, treciNiz)));
    }

}
