/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findByOrderNumber", query = "SELECT o FROM OrderDetails o WHERE o.orderNumber = :orderNumber"),
    @NamedQuery(name = "OrderDetails.findByCode", query = "SELECT o FROM OrderDetails o WHERE o.code = :code"),
    @NamedQuery(name = "OrderDetails.findByOrdered", query = "SELECT o FROM OrderDetails o WHERE o.ordered = :ordered"),
    @NamedQuery(name = "OrderDetails.findByPriceEach", query = "SELECT o FROM OrderDetails o WHERE o.priceEach = :priceEach"),
    @NamedQuery(name = "OrderDetails.findByOrderLineNumber", query = "SELECT o FROM OrderDetails o WHERE o.orderLineNumber = :orderLineNumber")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_number")
    private Integer orderNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordered")
    private int ordered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_each")
    private int priceEach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_line_number")
    private int orderLineNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderDetails")
    private Orders orders;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderDetailsFk")
    private List<Products> productsList;

    public OrderDetails() {
    }

    public OrderDetails(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderDetails(Integer orderNumber, String code, int ordered, int priceEach, int orderLineNumber) {
        this.orderNumber = orderNumber;
        this.code = code;
        this.ordered = ordered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @XmlTransient
    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNumber != null ? orderNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.orderNumber == null && other.orderNumber != null) || (this.orderNumber != null && !this.orderNumber.equals(other.orderNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetails[ orderNumber=" + orderNumber + " ]";
    }
    
}
