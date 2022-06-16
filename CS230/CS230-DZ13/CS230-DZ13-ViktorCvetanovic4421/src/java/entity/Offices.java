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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "offices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offices.findAll", query = "SELECT o FROM Offices o"),
    @NamedQuery(name = "Offices.findByOfficeCode", query = "SELECT o FROM Offices o WHERE o.officeCode = :officeCode"),
    @NamedQuery(name = "Offices.findByCity", query = "SELECT o FROM Offices o WHERE o.city = :city"),
    @NamedQuery(name = "Offices.findByPhone", query = "SELECT o FROM Offices o WHERE o.phone = :phone"),
    @NamedQuery(name = "Offices.findByAdderss", query = "SELECT o FROM Offices o WHERE o.adderss = :adderss"),
    @NamedQuery(name = "Offices.findByState", query = "SELECT o FROM Offices o WHERE o.state = :state"),
    @NamedQuery(name = "Offices.findByCountry", query = "SELECT o FROM Offices o WHERE o.country = :country"),
    @NamedQuery(name = "Offices.findByTerritory", query = "SELECT o FROM Offices o WHERE o.territory = :territory")})
public class Offices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "office_code")
    private Integer officeCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phone")
    private int phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "adderss")
    private String adderss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "territory")
    private String territory;

    public Offices() {
    }

    public Offices(Integer officeCode) {
        this.officeCode = officeCode;
    }

    public Offices(Integer officeCode, String city, int phone, String adderss, String state, String country, String territory) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.adderss = adderss;
        this.state = state;
        this.country = country;
        this.territory = territory;
    }

    public Integer getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Integer officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (officeCode != null ? officeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offices)) {
            return false;
        }
        Offices other = (Offices) object;
        if ((this.officeCode == null && other.officeCode != null) || (this.officeCode != null && !this.officeCode.equals(other.officeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Offices[ officeCode=" + officeCode + " ]";
    }
    
}
