/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
    , @NamedQuery(name = "Predmet.findById", query = "SELECT p FROM Predmet p WHERE p.id = :id")
    , @NamedQuery(name = "Predmet.findBySifraPredmeta", query = "SELECT p FROM Predmet p WHERE p.sifraPredmeta = :sifraPredmeta")
    , @NamedQuery(name = "Predmet.findByNazivPredmeta", query = "SELECT p FROM Predmet p WHERE p.nazivPredmeta = :nazivPredmeta")
    ,
    @NamedQuery(name = "Predmet.findbyAcademicYear", query = "SELLECT * FROM Predmet INNER JOIN Profesor ON id=profesor.id WHERE p.godina_izbora=:year")})
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sifra_predmeta")
    private String sifraPredmeta;
    @Column(name = "naziv_predmeta")
    private String nazivPredmeta;
    @JoinColumn(name = "fk_profesor", referencedColumnName = "id")
    @ManyToOne
    private Profesor fkProfesor;

    public Predmet() {
    }

    public Predmet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public Profesor getFkProfesor() {
        return fkProfesor;
    }

    public void setFkProfesor(Profesor fkProfesor) {
        this.fkProfesor = fkProfesor;
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
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Predmet[ id=" + id + " ]";
    }

}
