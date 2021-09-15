/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

import java.util.Objects;

/**
 *
 * @author vikto
 */
public class Student {

    private String ime;
    private String prezime;
    private int indeks;

    public Student() {
    }

    public Student(String ime, String prezime, int indeks) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
    }

    public Student(Student s) {
        this.ime = s.ime;
        this.indeks = s.indeks;
        this.prezime = s.prezime;
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

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Student) {
            Student s = (Student) obj;
            if (this.indeks == s.indeks && this.ime.equals(s.ime) && this.prezime.equals(s.prezime)) {
                return true;
            }
        }
        return false;
    }

}
