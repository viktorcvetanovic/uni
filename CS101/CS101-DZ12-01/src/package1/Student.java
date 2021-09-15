/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.util.Objects;

/**
 *
 * @author vikto
 */
public class Student {

    private String ime;
    private String prezime;
    private double prosek;
    private int indeks;

    public Student() {
    }

    public Student(String ime, String prezime, double prosek, int indeks) {
        this.ime = ime;
        this.prezime = prezime;
        this.prosek = prosek;
        this.indeks = indeks;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public Student(Student s) {
        this.ime = s.ime;
        this.prezime = s.prezime;
        this.prosek = s.prosek;
        this.indeks = s.indeks;
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

    public double getProsek() {
        return prosek;
    }

    public void setProsek(double prosek) {
        this.prosek = prosek;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", prosek=" + prosek + ", indeks=" + indeks + '}';
    }

}
