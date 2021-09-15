/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ImeNijeValidnoException;
import exceptions.IndeksNijeValidanException;

/**
 *
 * @author vikto
 */
public class Student {
    
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private String indeks;
    
    public Student() {
    }
    
    public Student(String ime, String prezime, String adresa, String grad, String indeks) throws ImeNijeValidnoException, IndeksNijeValidanException {
        setIme(ime);
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        setIndeks(indeks);
    }
    
    public String getIme() {
        return ime;
    }
    
    public void setIme(String ime) throws ImeNijeValidnoException {
        if (ime.length() >= 2) {
            this.ime = ime;
        } else {
            throw new ImeNijeValidnoException("Vase ime je prekratko");
        }
        
    }
    
    public String getPrezime() {
        return prezime;
    }
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    public String getAdresa() {
        return adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    public String getGrad() {
        return grad;
    }
    
    public void setGrad(String grad) {
        this.grad = grad;
    }
    
    public String getIndeks() {
        return indeks;
    }
    
    public void setIndeks(String indeks) throws IndeksNijeValidanException {
        if (indeks.length() == 4) {
            this.indeks = indeks;
        } else {
            throw new IndeksNijeValidanException("Indeks nije validan");
        }
        
    }
    
    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", grad=" + grad + ", indeks=" + indeks + '}';
    }
    
}
