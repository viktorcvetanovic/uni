/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author BiG
 */
@Named
@SessionScoped
public class BeanCDI implements Serializable {

    private String name;
    private int index;
    private String status;
    private String contact;
    private String role;
    private String address;
    private String city;
    private boolean traditional;
    private int postalCode;

    public BeanCDI() {
    }

    public BeanCDI(String name, int index, String status, String contact, String role, String address, String city, boolean traditional, int postalCode) {
        this.name = name;
        this.index = index;
        this.status = status;
        this.contact = contact;
        this.role = role;
        this.address = address;
        this.city = city;
        this.traditional = traditional;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isTraditional() {
        return traditional;
    }

    public void setTraditional(boolean traditional) {
        this.traditional = traditional;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "BeanCDI{" + "name=" + name + ", index=" + index + ", status=" + status + ", contact=" + contact + ", role=" + role + ", address=" + address + ", city=" + city + ", traditional=" + traditional + ", postalCode=" + postalCode + '}';
    }

}
