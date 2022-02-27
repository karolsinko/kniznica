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

    //ID uzivatela
    public String getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    //krstne meno uzivatela
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(){
        this.firstName = firstName;
    }
    //priezvisko uzivatela
    public String getLastName(){
        return lastName;
    }
    public void setLastName(){
        this.lastName = lastName;
    }
    //email uzivatela
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }
}
