package org.example.exception;

public class InstructorNotFoundException extends Exception {
    private String messaage;

    public InstructorNotFoundException(String messaage) {
        super();
        this.messaage = messaage;
    }

    public String getMessaage() {
        return messaage;
    }
}
