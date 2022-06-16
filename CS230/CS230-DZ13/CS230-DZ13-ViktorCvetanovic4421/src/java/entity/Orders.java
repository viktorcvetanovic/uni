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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrdersNumber", query = "SELECT o FROM Orders o WHERE o.ordersNumber = :ordersNumber"),
    @NamedQuery(name = "Orders.findByOrderDetailsFk", query = "SELECT o FROM Orders o WHERE o.orderDetailsFk = :orderDetailsFk"),
    @NamedQuery(name = "Orders.findByDate", query = "SELECT o FROM Orders o WHERE o.date = :date"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status"),
    @NamedQuery(name = "Orders.findByComments", query = "SELECT o FROM Orders o WHERE o.comments = :comments"),
    @NamedQuery(name = "Orders.findByCustomerNumber", query = "SELECT o FROM Orders o WHERE o.customerNumber = :customerNumber")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orders_number")
    private Integer ordersNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_details_fk")
    private int orderDetailsFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_number")
    private int customerNumber;
    @JoinColumn(name = "orders_number", referencedColumnName = "order_number", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrderDetails orderDetails;

    public Orders() {
    }

    public Orders(Integer ordersNumber) {
        this.ordersNumber = ordersNumber;
    }

    public Orders(Integer ordersNumber, int orderDetailsFk, Date date, String status, String comments, int customerNumber) {
        this.ordersNumber = ordersNumber;
        this.orderDetailsFk = orderDetailsFk;
        this.date = date;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public Integer getOrdersNumber() {
        return ordersNumber;
    }

    public void setOrdersNumber(Integer ordersNumber) {
        this.ordersNumber = ordersNumber;
    }

    public int getOrderDetailsFk() {
        return orderDetailsFk;
    }

    public void setOrderDetailsFk(int orderDetailsFk) {
        this.orderDetailsFk = orderDetailsFk;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordersNumber != null ? ordersNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.ordersNumber == null && other.ordersNumber != null) || (this.ordersNumber != null && !this.ordersNumber.equals(other.ordersNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ ordersNumber=" + ordersNumber + " ]";
    }
    
}
