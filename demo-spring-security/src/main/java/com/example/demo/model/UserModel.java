package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserModel {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "cncrypted_password")
    private String encrypteedPassword;

}