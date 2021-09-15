/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import exceptions.EmptyFieldException;
import exceptions.IndexInputException;

/**
 *
 * @author vikto
 */
public class Student {
    
    private String ime;
    private String prezime;
    private String indeks;
    
    public Student() {
    }
    
    public Student(String ime, String prezime, String indeks) throws EmptyFieldException, IndexInputException {
        setIme(ime);
        setIndeks(indeks);
        setPrezime(prezime);
    }
    
    public String getIme() {
        return ime;
    }
    
    public void setIme(String ime) throws EmptyFieldException {
        if (validacijaUnosa(ime)) {
            this.ime = ime;
        } else {
            throw new EmptyFieldException("Polje ne sme biti prazno");
        }
        
    }
    
    public String getPrezime() {
        return prezime;
    }
    
    public void setPrezime(String prezime) throws EmptyFieldException {
        if (validacijaUnosa(prezime)) {
            this.prezime = prezime;
        } else {
            throw new EmptyFieldException("Polje ne sme biti prazno");
        }
    }
    
    public String getIndeks() {
        return indeks;
    }
    
    public void setIndeks(String indeks) throws IndexInputException {
        if (validacijaIndeksa(indeks)) {
            this.indeks = indeks;
        } else {
            throw new IndexInputException("Pogresan indeks");
        }
    }
    
    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", indeks=" + indeks + '}';
    }
    
    public static boolean validacijaUnosa(String a) {
        if (a.length() > 0) {
            return true;
        }
        return false;
    }
    
    public static boolean validacijaIndeksa(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                return false;
            }
        }
        if (Integer.parseInt(a) > 0) {
            return true;
        }
        
        return false;
    }
    
}
