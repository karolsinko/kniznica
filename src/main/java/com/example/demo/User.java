package com.example.demo;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public User(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

//krstne meno
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(){
        this.firstName = firstName;
    }
//priezvisko
    public String getLastName(){
        return lastName;
    }
    public void setLastName(){
        this.lastName = lastName;
    }
//email
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }
}
