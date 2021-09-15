import crud.Baza;
import entity.Predmet;
import entity.Profesor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Unesti neku od opcija za brisanje i dodavanje profesora");
        System.out.println("1-add , 2-delete ,3-update ,4-readAll");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        switch (a) {
            case 1:
                System.out.println("Napravi profesora");
                System.out.println(" id;\n" +
                        "ime\n" +
                        "prezime;\n" +
                        "godinaIzbora;\n" +
                        "naslovDoktorata;  ");
                System.out.print("ime:");
                String ime = scanner.nextLine();
                System.out.print("prezime");
                String prezime = scanner.nextLine();
                System.out.print("godinaIzbora");
                int godinaIzbora = scanner.nextInt();
                scanner.nextLine();
                System.out.print("naslovDoktorata");
                String naslovDoktorata = scanner.nextLine();
                Baza.addProfesor(new Profesor(ime,prezime,godinaIzbora,naslovDoktorata));
                break;
            case 2:
                System.out.println("Unesite id za brisanje profesora");
                int id=scanner.nextInt();
                Baza.removeProfesor(id);
                break;
            case 3:
                System.out.println(" id;\n" +
                        "ime\n" +
                        "prezime;\n" +
                        "godinaIzbora;\n" +
                        "naslovDoktorata;  ");
                System.out.print("ime:");
                String ime1 = scanner.nextLine();
                System.out.print("prezime");
                String prezime1 = scanner.nextLine();
                System.out.print("godinaIzbora");
                int godinaIzbora1 = scanner.nextInt();
                scanner.nextLine();
                System.out.print("naslovDoktorata");
                String naslovDoktorata1 = scanner.nextLine();
                Baza.addProfesor(new Profesor(ime1,prezime1,godinaIzbora1,naslovDoktorata1));
                break;
            case 4:
                System.out.println("Citam sve profesore");
                Baza.readAllProfesor();
                break;
            default:
                System.out.println("Pogresna opcija");
                break;
        }

    }

}
