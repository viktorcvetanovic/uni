/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s1 = new Student("Djordje", "Bobicic", 2232, TipStudenta.TRADICIONALNI);
        Student s2 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s3 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s4 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s5 = new Student("Djordje", "Bobicic", 2232, TipStudenta.TRADICIONALNI);
        Student s6 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s7 = new Student("Djordje", "Bobicic", 2232, TipStudenta.TRADICIONALNI);
        Student s8 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s9 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s10 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s11 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s12 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s13 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s14 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);
        Student s15 = new Student("Djordje", "Bobicic", 2232, TipStudenta.INTERNER);

        Student niz[] = new Student[15];
        niz[0] = s1;
        niz[1] = s2;
        niz[2] = s3;
        niz[3] = s4;
        niz[4] = s5;
        niz[5] = s6;
        niz[6] = s7;
        niz[7] = s8;
        niz[8] = s9;
        niz[9] = s10;
        niz[10] = s11;
        niz[11] = s12;
        niz[12] = s13;
        niz[13] = s14;
        niz[14] = s15;
        Predmet p1 = new Predmet("Matematika", "0124", 123, niz);
        System.out.println(p1.brojTradicionalnihStudenata());

    }

}
