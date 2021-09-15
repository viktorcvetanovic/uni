/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak6;

/**
 *
 * @author vikto
 */
public class Student {

    private String ime;
    private String prezime;
    private int indeks;
    private double prosek;

    public Student() {
    }

    public Student(String ime, String prezime, int indeks, double prosek) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.prosek = prosek;
    }

    public Student(Student s) {
        this.ime = s.ime;
        this.prezime = s.prezime;
        this.indeks = s.indeks;
        this.prosek = s.prosek;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public double getProsek() {
        return prosek;
    }

    public void setProsek(double prosek) {
        this.prosek = prosek;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", indeks=" + indeks + ", prosek=" + prosek + '}';
    }

}
