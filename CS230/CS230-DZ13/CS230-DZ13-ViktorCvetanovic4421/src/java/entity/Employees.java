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
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeNumber", query = "SELECT e FROM Employees e WHERE e.employeeNumber = :employeeNumber"),
    @NamedQuery(name = "Employees.findByName", query = "SELECT e FROM Employees e WHERE e.name = :name"),
    @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email"),
    @NamedQuery(name = "Employees.findByOfficeCode", query = "SELECT e FROM Employees e WHERE e.officeCode = :officeCode"),
    @NamedQuery(name = "Employees.findByJobtItle", query = "SELECT e FROM Employees e WHERE e.jobtItle = :jobtItle")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_number")
    private Integer employeeNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private int name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email")
    private int email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "office_code")
    private int officeCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "job_tItle")
    private String jobtItle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeParent")
    private List<Employees> employeesList;
    @JoinColumn(name = "employee_parent", referencedColumnName = "employee_number")
    @ManyToOne(optional = false)
    private Employees employeeParent;

    public Employees() {
    }

    public Employees(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Employees(Integer employeeNumber, int name, int email, int officeCode, String jobtItle) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.email = email;
        this.officeCode = officeCode;
        this.jobtItle = jobtItle;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(int officeCode) {
        this.officeCode = officeCode;
    }

    public String getJobtItle() {
        return jobtItle;
    }

    public void setJobtItle(String jobtItle) {
        this.jobtItle = jobtItle;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Employees getEmployeeParent() {
        return employeeParent;
    }

    public void setEmployeeParent(Employees employeeParent) {
        this.employeeParent = employeeParent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeNumber != null ? employeeNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeNumber == null && other.employeeNumber != null) || (this.employeeNumber != null && !this.employeeNumber.equals(other.employeeNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employees[ employeeNumber=" + employeeNumber + " ]";
    }
    
}
