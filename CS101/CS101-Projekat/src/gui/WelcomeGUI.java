/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static checkUser.LoginRegister.login;
import static checkUser.LoginRegister.readKorisnik;
import static checkUser.LoginRegister.register;
import data.automobil.Automobil;
import data.firma.Firma;
import static data.firma.FirmaCars.sviAutomobili;
import data.korisnik.Korisnik;
import java.util.Scanner;
import static makeAutomobil.AutomobilAdd.napraviAutomobil;

/**
 *
 * @author vikto
 */
public class WelcomeGUI {

    /**
     * metoda koja prikazuje korisniku simulaciju interfejsa, poziva druge
     * metode register(),login()
     *
     *
     */
    public static void menuOne() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Dobrodosli u Audi webshop");
            System.out.println("Kako bi koristi nase usluge morate da se registrujete ili loginujete");
            System.out.println("Izaberite register/login");
            String unos = sc.nextLine();
            if (unos.equals("register")) {
                register();
                break;
            } else if (unos.equals("login")) {
                login();
                break;
            } else {
                System.out.println("Greska");
            }
        }
    }

    /**
     * maetoda koja takodje prikazuje korisniku simulaciju interfejsa, poziva
     * metodu koja kreira automobil, i cita korisnika
     *
     *
     */
    public static void menuTwo() {
        Scanner sc = new Scanner(System.in);
        Korisnik k = readKorisnik();
        while (true) {
            System.out.println();
            System.out.println("Sada napravite auto po vasoj zelji");

            Automobil a = napraviAutomobil();

            System.out.println("Vase stanje je " + k.getKartica().getStanje());
            System.out.println(k);
            System.out.println(a);
            a.izracunajCenu();
            System.out.println("Racun iznosi " + a.getCena());
            k.dodajAuto(a);
            k.kupi();
            System.out.println("Vase stanje je " + k.getKartica().getStanje());
            System.out.println("Da li zelite jos jedan auto ?");
            String odgovor = sc.nextLine();
            if (odgovor.toLowerCase().equals("ne")) {
                break;
            }
        }
    }

    public static void menuThree() {
        Scanner sc = new Scanner(System.in);
        Korisnik k = readKorisnik();
        System.out.println();
        System.out.println("Ovde mozete birati gotove automobile");
        Firma f = new Firma("Audo", "Nis", "123", k);
        f.setLista(sviAutomobili());
        f.prikaziGotoveAutomobile();
        System.out.println("Napisite redni broj auta koji zelite da kupite");
        int unos = sc.nextInt();
        k.dodajAuto(f.prikaziGotovAuto(unos));
        k.kupi();
        System.out.println("Uspesno ste kupili");
        System.out.println(k.getKartica().getStanje());
    }

}
