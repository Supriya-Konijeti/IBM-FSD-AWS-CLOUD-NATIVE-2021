package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class customer {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public customer() {
    }

    public customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getCustomerId() {
        return id;
    }

    public void setCustomerId(int customerId) {
        this.id = id;
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String customerName) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
