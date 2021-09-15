/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v04.zadatak1;

/**
 *
 * @author vikto
 */
public class Video {

    private String naziv;
    private String URL;

    public Video() {
    }

    public Video(String naziv, String URL) {
        this.naziv = naziv;
        this.URL = URL;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return this.naziv;
    }

}
