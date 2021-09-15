package entity;

import java.util.List;

public class Profesor {
    private int id;
    private String ime;
    private String prezime;
    private int godinaIzbora;
    private String naslovDoktorata;
    private List<Predmet> listaPredmeta;

    public Profesor() {
    }

    public Profesor( String ime, String prezime, int godinaIzbora, String naslovDoktorata ) {
        this.ime = ime;
        this.prezime = prezime;
        this.godinaIzbora = godinaIzbora;
        this.naslovDoktorata = naslovDoktorata;
    }
    public Profesor(int id, String ime, String prezime, int godinaIzbora, String naslovDoktorata) {
        this.id=id;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaIzbora = godinaIzbora;
        this.naslovDoktorata = naslovDoktorata;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getGodinaIzbora() {
        return godinaIzbora;
    }

    public void setGodinaIzbora(int godinaIzbora) {
        this.godinaIzbora = godinaIzbora;
    }

    public String getNaslovDoktorata() {
        return naslovDoktorata;
    }

    public void setNaslovDoktorata(String naslovDoktorata) {
        this.naslovDoktorata = naslovDoktorata;
    }

    public List<Predmet> getListaPredmeta() {
        return listaPredmeta;
    }

    public void setListaPredmeta(List<Predmet> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", godinaIzbora=" + godinaIzbora +
                ", naslovDoktorata='" + naslovDoktorata + '\'' +
                ", listaPredmeta=" + listaPredmeta +
                '}';
    }
}
