/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Student {

    private String ime;
    private String prezime;
    private int indeks;
    private List lista = new ArrayList<Integer>();

    public Student() {
    }

    public Student(String ime, String prezime, int indeks) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
    }

    public Student(Student s) {
        this.ime = s.ime;
        this.prezime = s.prezime;
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

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", indeks=" + indeks + ", lista=" + lista + '}';
    }

}
