/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Telefon t1 = new Telefon(10000, 6.7, "Mi10", 128);
        Telefon t2 = new Telefon(14000, 6.7, "x10", 25);
        Telefon t3 = new Telefon(15000, 6.7, "p20", 200);
        Telefon t4 = new Telefon(11000, 6.7, "s10", 128);
        Telefon t5 = new Telefon(26000, 6.7, "a10", 128);
        Telefon niz[] = new Telefon[5];
        niz[0] = t1;
        niz[1] = t2;
        niz[2] = t3;
        niz[3] = t4;
        niz[4] = t5;
        ProdavnicaTelefona pt1 = new ProdavnicaTelefona("BulevarNemanjica", "Nis", "Shop", niz);
        System.out.println(pt1.cenaTelefonaSaNajboljomKamerom());

    }

}
