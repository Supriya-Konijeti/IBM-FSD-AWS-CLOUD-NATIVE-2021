package com.example.demo.shared;

public class AccountResponseModel {
    private String accountId;
    private String firstName;
    private String lastName;
    private String email;
    public AccountResponseModel() {
        super();
    }
    public AccountResponseModel(String accountId, String firstName, String lastName, String email) {
        super();
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}