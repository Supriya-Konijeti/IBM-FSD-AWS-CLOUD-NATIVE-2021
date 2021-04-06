package org.example.exception;

public class CustomerNotFoundException extends Exception{
    private String messaage;

    public CustomerNotFoundException(String messaage) {
        super();
        this.messaage = messaage;
    }

    public String getMessaage() {
        return messaage;
    }
}
