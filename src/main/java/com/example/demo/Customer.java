package com.example.demo;

public class Customer {
    private String firstName;
    private String lastName;

    public String getCustomer() {
        return firstName + lastName;
    }

    public void setCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setCustomer(String customer) {
    }
}


