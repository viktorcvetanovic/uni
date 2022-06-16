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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductsCode", query = "SELECT p FROM Products p WHERE p.productsCode = :productsCode"),
    @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name"),
    @NamedQuery(name = "Products.findByLine", query = "SELECT p FROM Products p WHERE p.line = :line"),
    @NamedQuery(name = "Products.findByScale", query = "SELECT p FROM Products p WHERE p.scale = :scale"),
    @NamedQuery(name = "Products.findByVendor", query = "SELECT p FROM Products p WHERE p.vendor = :vendor"),
    @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description"),
    @NamedQuery(name = "Products.findByStock", query = "SELECT p FROM Products p WHERE p.stock = :stock"),
    @NamedQuery(name = "Products.findByBuyPrice", query = "SELECT p FROM Products p WHERE p.buyPrice = :buyPrice"),
    @NamedQuery(name = "Products.findByMsrp", query = "SELECT p FROM Products p WHERE p.msrp = :msrp")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "products_code")
    private Integer productsCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "line")
    private String line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scale")
    private int scale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vendor")
    private int vendor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "buyPrice")
    private int buyPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "msrp")
    private int msrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productsFk")
    private List<Productlines> productlinesList;
    @JoinColumn(name = "order_details_fk", referencedColumnName = "order_number")
    @ManyToOne(optional = false)
    private OrderDetails orderDetailsFk;

    public Products() {
    }

    public Products(Integer productsCode) {
        this.productsCode = productsCode;
    }

    public Products(Integer productsCode, String name, String line, int scale, int vendor, String description, int stock, int buyPrice, int msrp) {
        this.productsCode = productsCode;
        this.name = name;
        this.line = line;
        this.scale = scale;
        this.vendor = vendor;
        this.description = description;
        this.stock = stock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }

    public Integer getProductsCode() {
        return productsCode;
    }

    public void setProductsCode(Integer productsCode) {
        this.productsCode = productsCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getVendor() {
        return vendor;
    }

    public void setVendor(int vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getMsrp() {
        return msrp;
    }

    public void setMsrp(int msrp) {
        this.msrp = msrp;
    }

    @XmlTransient
    public List<Productlines> getProductlinesList() {
        return productlinesList;
    }

    public void setProductlinesList(List<Productlines> productlinesList) {
        this.productlinesList = productlinesList;
    }

    public OrderDetails getOrderDetailsFk() {
        return orderDetailsFk;
    }

    public void setOrderDetailsFk(OrderDetails orderDetailsFk) {
        this.orderDetailsFk = orderDetailsFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productsCode != null ? productsCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productsCode == null && other.productsCode != null) || (this.productsCode != null && !this.productsCode.equals(other.productsCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Products[ productsCode=" + productsCode + " ]";
    }
    
}
