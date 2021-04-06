package com.example.demo.shared;

public class AccountRequestModel {
        private String firstName;
        private String lastName;
        private String email;
        public AccountRequestModel() {
            super();
        }
        public AccountRequestModel(String firstName, String lastName, String email) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
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

