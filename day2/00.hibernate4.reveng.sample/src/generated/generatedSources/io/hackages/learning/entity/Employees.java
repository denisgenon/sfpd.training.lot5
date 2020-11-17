package io.hackages.learning.entity;
// Generated Nov 17, 2020 1:42:45 PM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Employees generated by hbm2java
 */
@Entity
@Table(name="employees"
    ,catalog="classicmodels"
)
public class Employees  implements java.io.Serializable {


     private int employeeNumber;
     private Offices offices;
     private Employees employees;
     private String lastName;
     private String firstName;
     private String extension;
     private String email;
     private String jobTitle;
     private Set employeeses = new HashSet(0);
     private Set customerses = new HashSet(0);

    public Employees() {
    }

	
    public Employees(int employeeNumber, Offices offices, String lastName, String firstName, String extension, String email, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.offices = offices;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.jobTitle = jobTitle;
    }
    public Employees(int employeeNumber, Offices offices, Employees employees, String lastName, String firstName, String extension, String email, String jobTitle, Set employeeses, Set customerses) {
       this.employeeNumber = employeeNumber;
       this.offices = offices;
       this.employees = employees;
       this.lastName = lastName;
       this.firstName = firstName;
       this.extension = extension;
       this.email = email;
       this.jobTitle = jobTitle;
       this.employeeses = employeeses;
       this.customerses = customerses;
    }
   
     @Id 
    
    @Column(name="employeeNumber", unique=true, nullable=false)
    public int getEmployeeNumber() {
        return this.employeeNumber;
    }
    
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="officeCode", nullable=false)
    public Offices getOffices() {
        return this.offices;
    }
    
    public void setOffices(Offices offices) {
        this.offices = offices;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="reportsTo")
    public Employees getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
    
    @Column(name="lastName", nullable=false, length=50)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="firstName", nullable=false, length=50)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="extension", nullable=false, length=10)
    public String getExtension() {
        return this.extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    @Column(name="email", nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="jobTitle", nullable=false, length=50)
    public String getJobTitle() {
        return this.jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employees")
    public Set getEmployeeses() {
        return this.employeeses;
    }
    
    public void setEmployeeses(Set employeeses) {
        this.employeeses = employeeses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employees")
    public Set getCustomerses() {
        return this.customerses;
    }
    
    public void setCustomerses(Set customerses) {
        this.customerses = customerses;
    }




}


