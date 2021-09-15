/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

public class Zadatak3 {

    public static String zamenamesta(String x) {

        return x.charAt(x.length() - 1) + x.substring(1, x.length() - 1) + (x.charAt(0));
    }

    public static String triStringa(String x) {

        return x.substring(0, 3) + x.substring(0, 3) + x.substring(0, 3);
    }

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(zamenamesta("Ivana"));
        System.out.println(triStringa("Ivana"));
    }

}
