package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="INSTRUCTOR")
public class Instructor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;
    public Instructor() {
        super();
    }

    public Instructor(String firstName, String lastName, String email ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
           }

    public Instructor(int id, String firstName, String lastName, String email, InstructorDetail instructorDetail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
       this.instructorDetail = instructorDetail;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' + ", instructorDetail=" + instructorDetail + '}';
    }
}
