/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package6;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zaposleni z1 = new Zaposleni("Viktor", "Cvetanovic", 10000, TipRadnika.IT);
        Zaposleni z2 = new Zaposleni("Vi", "Cvetanoic", 2000, TipRadnika.IT);
        Zaposleni z3 = new Zaposleni("Vikt", "Cvetavic", 3000, TipRadnika.HR);
        Zaposleni z4 = new Zaposleni("Vikt", "Cvetanic", 6000, TipRadnika.MENADZER);
        Zaposleni z5 = new Zaposleni("Vikdasr", "Cvetaic", 7000, TipRadnika.IT);
        Zaposleni z6 = new Zaposleni("Viktosar", "Ctvenic", 4000, TipRadnika.HR);
        Zaposleni z7 = new Zaposleni("Vir", "Cvetofhhfvic", 2400, TipRadnika.MENADZER);
        Zaposleni z8 = new Zaposleni("Vidaor", "Cvetvic", 5600, TipRadnika.HR);
        Zaposleni z9 = new Zaposleni("Vikdsar", "Cvetsdsaavic", 3120, TipRadnika.IT);
        Zaposleni z10 = new Zaposleni("Vidasor", "Cvetohffhvic", 4200, TipRadnika.IT);

        Zaposleni niz[] = new Zaposleni[10];
        niz[0] = z1;
        niz[1] = z2;
        niz[2] = z3;
        niz[3] = z4;
        niz[4] = z5;
        niz[5] = z6;
        niz[6] = z7;
        niz[7] = z8;
        niz[8] = z9;
        niz[9] = z10;
        Firma f1 = new Firma("Prodaja", "Sombroska", "12424", niz);
        System.out.println(f1.prosecnaZarada(TipRadnika.IT));
        System.out.println(f1.prosecnaZarada(TipRadnika.HR));
        System.out.println(f1.prosecnaZarada(TipRadnika.MENADZER));

    }

}
