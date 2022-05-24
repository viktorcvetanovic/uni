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
 * @author BiG
 */
@Entity
@Table(name = "productilnes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productilnes.findAll", query = "SELECT p FROM Productilnes p"),
    @NamedQuery(name = "Productilnes.findByProductLine", query = "SELECT p FROM Productilnes p WHERE p.productLine = :productLine"),
    @NamedQuery(name = "Productilnes.findByTextDescription", query = "SELECT p FROM Productilnes p WHERE p.textDescription = :textDescription"),
    @NamedQuery(name = "Productilnes.findByHtmlDescription", query = "SELECT p FROM Productilnes p WHERE p.htmlDescription = :htmlDescription"),
    @NamedQuery(name = "Productilnes.findByImage", query = "SELECT p FROM Productilnes p WHERE p.image = :image")})
public class Productilnes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_line")
    private Integer productLine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "text_description")
    private String textDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "html_description")
    private String htmlDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Products code;

    public Productilnes() {
    }

    public Productilnes(Integer productLine) {
        this.productLine = productLine;
    }

    public Productilnes(Integer productLine, String textDescription, String htmlDescription, String image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public Integer getProductLine() {
        return productLine;
    }

    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Products getCode() {
        return code;
    }

    public void setCode(Products code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productLine != null ? productLine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productilnes)) {
            return false;
        }
        Productilnes other = (Productilnes) object;
        if ((this.productLine == null && other.productLine != null) || (this.productLine != null && !this.productLine.equals(other.productLine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productilnes[ productLine=" + productLine + " ]";
    }
    
}
