package com.company;

import entity.Kupac;
import entity.Porudzbina;


import java.util.Scanner;

public class ConsoleCommunication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void firstMenu() {
        System.out.println("Dobrodosli u data bazu");
        System.out.println("Ovo su sledece opcije");
        System.out.println("Korisnik:1");
        System.out.println("Porudzbina:2");

        int entry = scanner.nextInt();
        if (entry == 1) {
            System.out.println("Usli ste u meni za CRUD usera");
            System.out.println("Ovo su sledece opcije");
            System.out.println("Obrisi usera:1");
            System.out.println("Dodaj usera:2");
            System.out.println("Promeni usera:3");
            System.out.println("Procitaj sve usere:4");
            int entryKupac = scanner.nextInt();
            scanner.nextLine();
            switch (entryKupac) {
                case 1:
                    helpRemoveKupac();
                    break;
                case 2:
                    helpAddKupac();
                    break;
                case 3:
                    helpUpdateKupac();
                    break;
                case 4:
                    DataBaseController.readAllKupac();
                    break;
                default:
                    System.out.println("Los izbor");
                    break;
            }
        } else if (entry == 2) {
            System.out.println("Usli ste u meni za CRUD porudzbine");
            System.out.println("Ovo su sledece opcije");
            System.out.println("Obrisi porudzbinu:1");
            System.out.println("Dodaj porudzbinu:2");
            System.out.println("Promeni porudzbinu:3");
            System.out.println("Procitaj sve porudzbine:4");
            int entryPorudzbina = scanner.nextInt();
            switch (entryPorudzbina) {
                case 1:
                    helpRemovePorudzbina();
                    break;
                case 2:
                    helpAddPorudzbina();
                    break;
                case 3:
                    helpUpdatePorudzbina();
                    break;
                case 4:
                    DataBaseController.readAllPorudzbina();
                    break;
                default:
                    System.out.println("Los izbor");
                    break;
            }
        } else {
            System.out.println("Pogresna opcija");

        }
    }

    private static void helpUpdatePorudzbina() {
        System.out.println("Unesite id porudzbine koje zelite da promenite i njene informacije");
        scanner.nextLine();
        System.out.println("Unesi id");
        int id=scanner.nextInt();
        System.out.println("Unesite id kupca");
        int idKorisnika= scanner.nextInt();
        System.out.println("Unesite broj dana isporue");
        int brojDanaIsporuke=scanner.nextInt();
        Porudzbina porudzbina = new Porudzbina(id,idKorisnika,brojDanaIsporuke);
        int status = DataBaseController.updatePorudzbina(porudzbina);
        checkStatus(status);
    }

    private static void helpAddPorudzbina() {
        System.out.println("Unesite informacije porudzbine koje zelite da dodate");
        scanner.nextLine();
        System.out.println("Unesi id");
        int id=scanner.nextInt();
        System.out.println("Unesite id kupca");
        int idKorisnika= scanner.nextInt();
        System.out.println("Unesite broj dana isporue");
        int brojDanaIsporuke=scanner.nextInt();
        Porudzbina porudzbina = new Porudzbina(id,idKorisnika,brojDanaIsporuke);
        int status = DataBaseController.addPorudzbina(porudzbina);
        checkStatus(status);
    }

    private static void helpRemovePorudzbina() {
        System.out.println("Unesite id porudzbine koje zelite da obrisete");
        int entry= scanner.nextInt();
        int status =DataBaseController.removePorudzbina(entry);
        checkStatus(status);
    }

    public static void helpRemoveKupac() {
        System.out.println("Unesite id kupca kog zelite da obrisete");
        int entry= scanner.nextInt();
        int status =DataBaseController.removeKupac(entry);
        checkStatus(status);
    }

    public static void helpAddKupac() {
        System.out.println("Unesite informacije kupca kog zelite da dodate");
        System.out.println("Unesi ime");
        String ime=scanner.nextLine();
        System.out.println();
        System.out.println("Unesite prezime");
        String prezime= scanner.nextLine();
        System.out.println();
        System.out.println("Unesite drazvu");
        String drzava=scanner.nextLine();
        Kupac kupac= Kupac.of(ime,prezime ,drzava );
        int status= DataBaseController.addKupac(kupac);
        checkStatus(status);
    }

    public static void helpUpdateKupac() {
        System.out.println("Unesite id kupca kog zelite da promenite i njegove informacije");
        System.out.println("Unesite id");
        int id= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Unesi ime");
        String ime=scanner.nextLine();
        System.out.println("Unesite prezime");
        String prezime= scanner.nextLine();
        System.out.println("Unesite drazvu");
        String drzava=scanner.nextLine();
        Kupac kupac=Kupac.ofWithId(id,ime,prezime,drzava);
        int status = DataBaseController.updateKupac(kupac);
        checkStatus(status);
    }

    public static void checkStatus(int status){
        if(status==1){
            System.out.println("Uspesno ste izvrsili upit");
        }else{
            System.out.println("Doslo je do greske proverite da li korisnik sa tim ID-om postoji");
        }
    }

}
