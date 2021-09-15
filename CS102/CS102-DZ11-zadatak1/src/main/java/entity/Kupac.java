package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Kupac {
    private Long id;
    private String ime;
    private String prezime;
    private String drzava;
    private Collection<Porudzbina> porudzbinasById;

    @Override
    public String toString() {
        return "Kupac{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", drzava='" + drzava + '\'' +
                ", porudzbinasById=" + porudzbinasById +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ime")
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "prezime")
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "drzava")
    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kupac kupac = (Kupac) o;

        if (id != null ? !id.equals(kupac.id) : kupac.id != null) return false;
        if (ime != null ? !ime.equals(kupac.ime) : kupac.ime != null) return false;
        if (prezime != null ? !prezime.equals(kupac.prezime) : kupac.prezime != null) return false;
        if (drzava != null ? !drzava.equals(kupac.drzava) : kupac.drzava != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (drzava != null ? drzava.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kupacByFkKupac")
    public Collection<Porudzbina> getPorudzbinasById() {
        return porudzbinasById;
    }

    public void setPorudzbinasById(Collection<Porudzbina> porudzbinasById) {
        this.porudzbinasById = porudzbinasById;
    }
}
