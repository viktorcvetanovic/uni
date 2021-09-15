/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package11;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Obrok o = new ZdravObrok(10, 10, 10);
        Obrok o1 = new NezdravObrok(5, 5, 5);

        Obrok niz[] = new Obrok[2];
        niz[0] = o;
        niz[1] = o1;
        System.out.println(racunajUkupnoKalorije(niz));
    }

    public static double racunajUkupnoKalorije(Obrok niz[]) {
        double vrednost = 0;
        for (int i = 0; i < niz.length; i++) {
            vrednost += niz[i].racunajKalorije();
        }
        return vrednost;
    }
}
