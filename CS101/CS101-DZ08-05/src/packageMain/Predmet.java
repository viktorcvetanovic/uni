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
public class Predmet {

    private String naziv;
    private String sifra;
    private int espb;
    private Student niz[] = new Student[15];

    public Predmet() {
    }

    public Predmet(String naziv, String sifra, int espb, Student niz[]) {
        this.naziv = naziv;
        this.sifra = sifra;
        this.espb = espb;
        this.niz = niz;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public Student[] getNiz() {
        return niz;
    }

    public void setNiz(Student[] niz) {
        this.niz = niz;
    }

    @Override
    public String toString() {
        return "Predmet{" + "naziv=" + naziv + ", sifra=" + sifra + ", espb=" + espb + ", niz=" + niz + '}';
    }

    public int brojTradicionalnihStudenata() {
        int count = 0;
        for (Student s : this.niz) {
            if (s.getTip().ordinal() == TipStudenta.TRADICIONALNI.ordinal()) {
                count += 1;
            }
        }
        return count;
    }

}
