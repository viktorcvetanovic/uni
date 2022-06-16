/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p"),
    @NamedQuery(name = "Payments.findByCheckNumber", query = "SELECT p FROM Payments p WHERE p.checkNumber = :checkNumber"),
    @NamedQuery(name = "Payments.findByDate", query = "SELECT p FROM Payments p WHERE p.date = :date"),
    @NamedQuery(name = "Payments.findByAmount", query = "SELECT p FROM Payments p WHERE p.amount = :amount")})
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "check_number")
    private Integer checkNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "customer_number", referencedColumnName = "customer_number")
    @ManyToOne(optional = false)
    private Customers customerNumber;

    public Payments() {
    }

    public Payments(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Payments(Integer checkNumber, Date date, int amount) {
        this.checkNumber = checkNumber;
        this.date = date;
        this.amount = amount;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customers getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Customers customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkNumber != null ? checkNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.checkNumber == null && other.checkNumber != null) || (this.checkNumber != null && !this.checkNumber.equals(other.checkNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payments[ checkNumber=" + checkNumber + " ]";
    }
    
}
