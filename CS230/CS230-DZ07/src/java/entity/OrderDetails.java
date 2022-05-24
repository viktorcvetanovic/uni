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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BiG
 */
@Entity
@Table(name = "order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findByQuantityOrdered", query = "SELECT o FROM OrderDetails o WHERE o.quantityOrdered = :quantityOrdered"),
    @NamedQuery(name = "OrderDetails.findByPriceEach", query = "SELECT o FROM OrderDetails o WHERE o.priceEach = :priceEach"),
    @NamedQuery(name = "OrderDetails.findByOrderLineNumber", query = "SELECT o FROM OrderDetails o WHERE o.orderLineNumber = :orderLineNumber"),
    @NamedQuery(name = "OrderDetails.findByDetailsId", query = "SELECT o FROM OrderDetails o WHERE o.detailsId = :detailsId")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity_ordered")
    private int quantityOrdered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_each")
    private int priceEach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_line_number")
    private int orderLineNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "details_id")
    private Integer detailsId;
    @JoinColumn(name = "order_number", referencedColumnName = "order_")
    @ManyToOne(optional = false)
    private Orders orderNumber;
    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Products code;

    public OrderDetails() {
    }

    public OrderDetails(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public OrderDetails(Integer detailsId, int quantityOrdered, int priceEach, int orderLineNumber) {
        this.detailsId = detailsId;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public int getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(int priceEach) {
        this.priceEach = priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Orders getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Orders orderNumber) {
        this.orderNumber = orderNumber;
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
        hash += (detailsId != null ? detailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.detailsId == null && other.detailsId != null) || (this.detailsId != null && !this.detailsId.equals(other.detailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetails[ detailsId=" + detailsId + " ]";
    }
    
}
