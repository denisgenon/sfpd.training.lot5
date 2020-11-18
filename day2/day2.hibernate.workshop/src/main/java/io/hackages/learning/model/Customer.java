package io.hackages.learning.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false, unique = true)
    private String alias;

    @Column(length = 64, nullable = false, unique = true)
    private String emailAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String alias, String emailAddress) {
        this.alias = alias;
        this.emailAddress = emailAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<CustomerOrder> getOrders() {
        return customerOrders;
    }

    public void setOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
