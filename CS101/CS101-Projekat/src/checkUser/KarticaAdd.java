/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkUser;

import data.korisnik.Kartica;
import enums.TipKartice;
import exceptions.kartica.InvalidKartica;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class KarticaAdd {

    /**
     * pravi i dodaje karticu korisniku
     *
     * @return k vraca karticu
     */
    public static Kartica dodajKarticu() {
        Scanner sc = new Scanner(System.in);
        Kartica k = new Kartica();
        while (true) {
            System.out.println("Dodajte vasu karticu");
            System.out.println("Broj vase kartice");
            String brojKartice = sc.nextLine();
            System.out.println("Tip vase kartice");
            TipKartice tip = TipKartice.valueOf(sc.nextLine().toUpperCase());
            k = new Kartica(brojKartice, 50000, tip);

            return k;

        }

    }
}
