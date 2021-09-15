/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak7;

import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author vikto
 */
public class Student implements Comparable<Student> {

    private String ime;
    private String prezime;
    private int indeks;
    private String JMBG;

    public Student() {
    }

    public Student(String ime, String prezime, int indeks, String JMBG) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.JMBG = JMBG;
    }

    public Student(Student s) {
        this.ime = s.ime;
        this.prezime = s.prezime;
        this.indeks = s.indeks;
        this.JMBG = s.JMBG;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", indeks=" + indeks + ", JMBG=" + JMBG + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Student) {
            Student s = (Student) obj;
            if (this.ime.equals(s.ime) && this.prezime.equals(s.prezime) && this.indeks == s.indeks && this.JMBG.equals(s.JMBG)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Student s) {
        if (this.ime.equals(s.ime) && this.prezime.equals(s.prezime) && this.indeks == s.indeks && this.JMBG.equals(s.JMBG)) {
            return 0;
        }
        if (this.prezime.compareTo(s.prezime) == 1) {
            return 1;
        } else if (this.prezime.compareTo(s.prezime) == 0) {
            if (this.ime.compareTo(s.ime) == 1) {
                return 1;
            } else if (this.ime.compareTo(s.ime) == 0) {
                if (this.indeks > s.indeks) {
                    return 1;
                } else if (this.indeks == s.indeks) {
                    return 0;
                }
            }
        }
        return -1;
    }

}
