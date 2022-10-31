/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispit.jpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author vikto
 */
@Entity
@Table(name = "product_cart")
@NamedQueries({
    @NamedQuery(name = "ProductCart.findAll", query = "SELECT p FROM ProductCart p"),
    @NamedQuery(name = "ProductCart.findByProductId", query = "SELECT p FROM ProductCart p WHERE p.productCartPK.productId = :productId"),
    @NamedQuery(name = "ProductCart.findByCartId", query = "SELECT p FROM ProductCart p WHERE p.productCartPK.cartId = :cartId"),
    @NamedQuery(name = "ProductCart.findByQuantity", query = "SELECT p FROM ProductCart p WHERE p.quantity = :quantity")})
public class ProductCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductCartPK productCartPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ShoppingCart shoppingCart;

    public ProductCart() {
    }

    public ProductCart(ProductCartPK productCartPK) {
        this.productCartPK = productCartPK;
    }

    public ProductCart(int productId, int cartId) {
        this.productCartPK = new ProductCartPK(productId, cartId);
    }

    public ProductCartPK getProductCartPK() {
        return productCartPK;
    }

    public void setProductCartPK(ProductCartPK productCartPK) {
        this.productCartPK = productCartPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCartPK != null ? productCartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCart)) {
            return false;
        }
        ProductCart other = (ProductCart) object;
        if ((this.productCartPK == null && other.productCartPK != null) || (this.productCartPK != null && !this.productCartPK.equals(other.productCartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ispit.jpa.entity.ProductCart[ productCartPK=" + productCartPK + " ]";
    }
    
}
