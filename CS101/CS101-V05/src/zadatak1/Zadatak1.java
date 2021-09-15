/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

/**
 *
 * @author vikto
 */
public class Zadatak1 {
//izracunava povrsinu jednakokrakog trougla
    //@a-strniaca
    //h-visina

    public static double povrsinajednakokrakog(double a, double h) {
        double povrsina = 0;
        povrsina = (a * h) / 2;

        return povrsina;
    }
//izracunava povrsinu jednakostranicnog trougla
    //@a-strniaca

    public static double povrsinajednakostranicnog(double a) {
        double povrsina = 0;
        povrsina = (Math.pow(a, 2) * Math.sqrt(3)) / 4;

        return povrsina;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(povrsinajednakokrakog(3, 4));
        System.out.println(povrsinajednakostranicnog(3));
    }

}
