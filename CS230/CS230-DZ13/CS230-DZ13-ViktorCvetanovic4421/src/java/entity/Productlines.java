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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "productlines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productlines.findAll", query = "SELECT p FROM Productlines p"),
    @NamedQuery(name = "Productlines.findByProductline", query = "SELECT p FROM Productlines p WHERE p.productline = :productline"),
    @NamedQuery(name = "Productlines.findByText", query = "SELECT p FROM Productlines p WHERE p.text = :text"),
    @NamedQuery(name = "Productlines.findByHtml", query = "SELECT p FROM Productlines p WHERE p.html = :html"),
    @NamedQuery(name = "Productlines.findByImage", query = "SELECT p FROM Productlines p WHERE p.image = :image")})
public class Productlines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productline")
    private Integer productline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "html")
    private String html;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "products_fk", referencedColumnName = "products_code")
    @ManyToOne(optional = false)
    private Products productsFk;

    public Productlines() {
    }

    public Productlines(Integer productline) {
        this.productline = productline;
    }

    public Productlines(Integer productline, String text, String html, String image) {
        this.productline = productline;
        this.text = text;
        this.html = html;
        this.image = image;
    }

    public Integer getProductline() {
        return productline;
    }

    public void setProductline(Integer productline) {
        this.productline = productline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Products getProductsFk() {
        return productsFk;
    }

    public void setProductsFk(Products productsFk) {
        this.productsFk = productsFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productline != null ? productline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productlines)) {
            return false;
        }
        Productlines other = (Productlines) object;
        if ((this.productline == null && other.productline != null) || (this.productline != null && !this.productline.equals(other.productline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productlines[ productline=" + productline + " ]";
    }
    
}
