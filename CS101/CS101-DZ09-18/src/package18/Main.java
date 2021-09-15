/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package18;

import java.util.Arrays;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pitanje p1 = new Pitanje(1, 10, OdgovorTacnost.TACNO);
        Pitanje p2 = new Pitanje(2, 20, OdgovorTacnost.TACNO);
        Pitanje p3 = new Pitanje(3, 20, OdgovorTacnost.TACNO);
        Pitanje p4 = new Pitanje(3, 30, OdgovorTacnost.TACNO);

        Ucesnik u1 = new Ucesnik("Sasa", "Stanisic", 2001, "Nis", Arrays.asList(p1, p2, p3));
        Ucesnik u2 = new Ucesnik("Viktor", "Cvetanovic", 2001, "Nis", Arrays.asList(p1, p2, p4));

        Kviz k = new Kviz(Arrays.asList(u1, u2));
        k.nadjiPobednika();
        System.out.println(k.getPobednik());
    }

}
