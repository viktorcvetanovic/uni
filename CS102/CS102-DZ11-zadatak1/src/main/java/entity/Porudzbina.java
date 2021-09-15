package entity;

import javax.persistence.*;

@Entity
public class Porudzbina {
    private Long id;
    private Integer brojDanaIsporuke;
    private Kupac kupacByFkKupac;

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
    @Column(name = "broj_dana_isporuke")
    public Integer getBrojDanaIsporuke() {
        return brojDanaIsporuke;
    }

    public void setBrojDanaIsporuke(Integer brojDanaIsporuke) {
        this.brojDanaIsporuke = brojDanaIsporuke;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Porudzbina that = (Porudzbina) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brojDanaIsporuke != null ? !brojDanaIsporuke.equals(that.brojDanaIsporuke) : that.brojDanaIsporuke != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brojDanaIsporuke != null ? brojDanaIsporuke.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_kupac", referencedColumnName = "id")
    public Kupac getKupacByFkKupac() {
        return kupacByFkKupac;
    }

    public void setKupacByFkKupac(Kupac kupacByFkKupac) {
        this.kupacByFkKupac = kupacByFkKupac;
    }
}
