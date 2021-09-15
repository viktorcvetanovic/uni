/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package8;

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
        Clan c1 = new Clan("Viktor", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c2 = new Clan("Vik", "Cvetanovic", TipClana.REKREATIVAC);
        Clan c3 = new Clan("Pera", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c4 = new Clan("Vior", "Cvetanovic", TipClana.REKREATIVAC);
        Clan c5 = new Clan("tor", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c6 = new Clan("Milan", "Cvetanovic", TipClana.REKREATIVAC);
        Clan c7 = new Clan("Spor", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c8 = new Clan("FSAF", "Cvetanovic", TipClana.REKREATIVAC);
        Clan c9 = new Clan("AAAA", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c10 = new Clan("SAle", "Cvetanovic", TipClana.REKREATIVAC);
        Clan c11 = new Clan("Petar", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c12 = new Clan("Nikola", "Cvetanovic", TipClana.REKREATIVAC);
        Clan c13 = new Clan("Maja", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c14 = new Clan("Nikolija", "Cvetanovic", TipClana.REDOVNICLAN);
        Clan c15 = new Clan("Andrijana", "Cvetanovic", TipClana.REDOVNICLAN);

        Clan niz[] = new Clan[15];
        niz[0] = c1;
        niz[1] = c2;
        niz[2] = c3;
        niz[3] = c4;
        niz[4] = c5;
        niz[5] = c6;
        niz[6] = c7;
        niz[7] = c8;
        niz[8] = c9;
        niz[9] = c10;
        niz[10] = c11;
        niz[11] = c12;
        niz[12] = c13;
        niz[13] = c14;
        niz[14] = c15;

        Teretana t1 = new Teretana("Saletov gym", "Kursumlija 32/5", "123", 2000, niz);
        System.out.print(t1.zaradaTeretane());

    }

}
