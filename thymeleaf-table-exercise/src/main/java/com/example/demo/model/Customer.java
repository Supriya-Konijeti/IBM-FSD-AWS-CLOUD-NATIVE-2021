package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Customer_DETAIL")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int customerId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "address")
    private String address;

    public Customer() {
    }

    public Customer(int id, String firstname, String lastname, String address) {
        this.customerId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public Customer(String firstname, String lastname, String address) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
    }

    public int getId() {
        return customerId;
    }

    public void setId(int id) {
        this.customerId = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
