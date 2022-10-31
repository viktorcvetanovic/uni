/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispit.jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author vikto
 */
@Embeddable
public class ProductCartPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Basic(optional = false)
    @Column(name = "CART_ID")
    private int cartId;

    public ProductCartPK() {
    }

    public ProductCartPK(int productId, int cartId) {
        this.productId = productId;
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productId;
        hash += (int) cartId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCartPK)) {
            return false;
        }
        ProductCartPK other = (ProductCartPK) object;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.cartId != other.cartId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ispit.jpa.entity.ProductCartPK[ productId=" + productId + ", cartId=" + cartId + " ]";
    }
    
}
