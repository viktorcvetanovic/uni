/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak6;

public class Student {

    private String ime;
    private String prezime;
    private Integer brIndeks;

    public Student() {
    }

    public Student(String ime, String prezime, Integer brIndeks) {
        this.ime = ime;
        this.prezime = prezime;
        this.brIndeks = brIndeks;
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

    public Integer getBrIndeks() {
        return brIndeks;
    }

    public void setBrIndeks(Integer brIndeks) {
        this.brIndeks = brIndeks;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", brIndeks=" + brIndeks + '}';
    }

}
