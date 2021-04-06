package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {
    @JsonIgnore
    private String empoyeeId;
    private String firstname;
    private String lastname;
    private String email;

    public Employee() {
    }

    public Employee(String empoyeeId, String firstname, String lastname, String email) {
        this.empoyeeId = empoyeeId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getEmpoyeeId() {
        return empoyeeId;
    }

    public void setEmpoyeeId(String empoyeeId) {
        this.empoyeeId = empoyeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empoyeeId='" + empoyeeId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
