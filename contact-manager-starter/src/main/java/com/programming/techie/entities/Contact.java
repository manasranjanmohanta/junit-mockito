package com.programming.techie.entities;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void validateFirstName() {
        if (this.firstName.isBlank()) {
            throw new RuntimeException("First name cannot be blank");
        }
    }

    public void validateLastName() {
        if (this.lastName.isBlank()) {
            throw new RuntimeException("Last name cannot be blank");
        }
    }

    public void validatePhoneNumber() {
        if (this.phoneNumber.isBlank()) {
            throw new RuntimeException("Phone number can not be blank");
        }

        if (this.phoneNumber.length() != 10) {
            throw new RuntimeException("Phone Number should be 10 digits Long");
        }

        if (!this.phoneNumber.matches("\\d+")) {
            throw new RuntimeException("Phone Number contain only digits");
        }

        if (!this.phoneNumber.startsWith("0")) {
            throw new RuntimeException("Phone Number should start with 0");
        }
    }
}
