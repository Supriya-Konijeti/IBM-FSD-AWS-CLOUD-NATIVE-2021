package com.example.demo.model;

public class Employee {
        private int id;
        private String firstname;
        private String lastname;
        private String email;

        public Employee() {
        }

        public Employee(int id, String firstname, String lastname, String email) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
                    "id=" + id +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


