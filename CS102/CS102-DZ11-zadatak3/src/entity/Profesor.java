/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findById", query = "SELECT p FROM Profesor p WHERE p.id = :id")
    , @NamedQuery(name = "Profesor.findByIme", query = "SELECT p FROM Profesor p WHERE p.ime = :ime")
    , @NamedQuery(name = "Profesor.findByPrezime", query = "SELECT p FROM Profesor p WHERE p.prezime = :prezime")
    , @NamedQuery(name = "Profesor.findByGodinaIzbora", query = "SELECT p FROM Profesor p WHERE p.godinaIzbora = :godinaIzbora")
    , @NamedQuery(name = "Profesor.findByNaslovDoktorata", query = "SELECT p FROM Profesor p WHERE p.naslovDoktorata = :naslovDoktorata")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "godina_izbora")
    private Integer godinaIzbora;
    @Column(name = "naslov_doktorata")
    private String naslovDoktorata;
    @OneToMany(mappedBy = "fkProfesor")
    private List<Predmet> predmetList;

    public Profesor() {
    }

    public Profesor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getGodinaIzbora() {
        return godinaIzbora;
    }

    public void setGodinaIzbora(Integer godinaIzbora) {
        this.godinaIzbora = godinaIzbora;
    }

    public String getNaslovDoktorata() {
        return naslovDoktorata;
    }

    public void setNaslovDoktorata(String naslovDoktorata) {
        this.naslovDoktorata = naslovDoktorata;
    }

    @XmlTransient
    public List<Predmet> getPredmetList() {
        return predmetList;
    }

    public void setPredmetList(List<Predmet> predmetList) {
        this.predmetList = predmetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Profesor[ id=" + id + " ]";
    }

}
