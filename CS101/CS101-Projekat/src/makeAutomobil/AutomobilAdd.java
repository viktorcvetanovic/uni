/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeAutomobil;

import data.automobil.Automobil;
import data.automobil.garancija.Garancija;
import data.automobil.opema.Boja;
import data.automobil.opema.Oprema;
import data.automobil.opema.Svetla;
import enums.TipAutomobila;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class AutomobilAdd {

    /**
     * metoda za pravljenje klase Automobil
     *
     *
     * @return a;
     */
    public static Automobil napraviAutomobil() {
        Scanner sc = new Scanner(System.in);
        Automobil a = new Automobil();
        while (true) {
            System.out.println();
            System.out.println("Unesti broj vrata");
            int brojVrata = sc.nextInt();
            sc.nextLine();
            System.out.println("Unesti naziv");
            String naziv = sc.nextLine();
            System.out.println("Unesite tip automobila(kupe,limuzina,dzip)");
            TipAutomobila tip = TipAutomobila.valueOf(sc.nextLine().toUpperCase());
            System.out.println("Dodajte dodatnu opremu i garanciju");

            Garancija garancija = napraviGaranciju();
            List<Oprema> oprema = napraviOpremu();
            a = new Automobil(brojVrata, naziv, tip, oprema, garancija);

            return a;
        }

    }

    /**
     * metoda za pravljenje liste od klase Oprema
     *
     *
     * @return o
     */
    public static List<Oprema> napraviOpremu() {
        List<Oprema> o = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ovde mozete birati opremu");
        System.out.println("Ovo je lista dodatne opreme izaberite koju zelite unosom broja");
        System.out.println("Mozete izabrati samo jedan dodatak opremi");
        System.out.println("Unesite 0 za nista, 1 za izbor svetla ili 2 za izbor boje");
        String unos = sc.nextLine();
        switch (unos) {
            case "0":

                break;
            case "1":
                System.out.println("Izaberite tip svetla");
                String svetla = sc.nextLine();
                Svetla s = new Svetla(svetla);
                o.add(s);
                break;
            case "2":
                System.out.println("Izaberite boju");
                String boja = sc.nextLine();
                Boja b = new Boja(boja);
                o.add(b);
                break;

        }
        return o;
    }

    /**
     * metoda za pravljenje klase Garancija
     *
     * @return Garancija();
     */
    public static Garancija napraviGaranciju() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ovde mozete birati garanciju");
        System.out.println("Izaberite koliko godina vas pokriva");
        int duzina = sc.nextInt();
        System.out.println("Izaberite koliko je cenovno pokrice");
        int maxVrednost = sc.nextInt();

        return new Garancija(duzina, maxVrednost);
    }
}
