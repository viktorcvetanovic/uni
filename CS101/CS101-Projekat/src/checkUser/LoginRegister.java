/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkUser;

import static checkUser.KarticaAdd.dodajKarticu;
import static checkUser.LoginRegisterChecker.checkIme;
import data.automobil.Automobil;
import data.korisnik.Kartica;
import data.korisnik.Korisnik;
import exceptions.korisnik.InvalidKorisnikException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikto
 */
public class LoginRegister {

    /**
     * upisuje korisnika u fajl
     *
     * @param k prima korisnika
     *
     */
    public static void addKorisnikToFile(Korisnik k) {

        try {
            FileOutputStream f = new FileOutputStream(new File("data.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(k);
            o.close();
            f.close();

        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    /**
     * pravi novog korisnika i upisuje ga u fajl
     *
     *
     */
    public static void register() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------");
            System.out.println("Registrujte se");

            System.out.println("Ime:");
            String ime = sc.nextLine();

            System.out.println("Prezime:");
            String prezime = sc.nextLine();

            System.out.println("email:");
            String email = sc.nextLine();

            System.out.println("sifra:");
            String sifra = sc.nextLine();

            try {
                // dodajKarticu() problem pri dodavanju jos jednog objekta, ne moze da procita
                List<Automobil> a = new ArrayList<>();
                Korisnik k = new Korisnik(ime, prezime, email, sifra, dodajKarticu(), a);

                addKorisnikToFile(k);
                System.out.println("Da li zelite da se sada logujete");
                String izbor = sc.nextLine();

                if (izbor.equals("da")) {
                    login();
                }

                break;
            } catch (InvalidKorisnikException ex) {
                sc.nextLine();
                System.err.print(ex.getMessage());
            }

        }
    }

    /**
     * pzoivta metodu pomocu kojeg trazi korisnika s odgovarajucim podacima koji
     * se unesu
     *
     *
     */
    public static void login() {
        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------");
            System.out.println("Kako bi se logovali potrebno je unesti email i sifru");

            System.out.println("email:");
            String email = sc.nextLine();

            System.out.println("sifra:");
            String sifra = sc.nextLine();

            Korisnik k = readKorisnik();

            if (k.getEmail().equals(email) && k.getSifra().equals(sifra)) {
                System.out.println("Uspesno ste se ulogovali");

                System.out.print(k);
                break;
            } else {
                System.err.println("Pogresni podaci !");
            }

        }
    }

    public static Korisnik readKorisnik() {

        try {
            FileInputStream f = new FileInputStream(new File("data.txt"));
            ObjectInputStream o = new ObjectInputStream(f);
//            Korisnik[] ko = (Korisnik[]) o.readObject();
            Korisnik k = (Korisnik) o.readObject();
            f.close();
            o.close();
            return k;
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        return null;
    }

}
