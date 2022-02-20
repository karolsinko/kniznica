package com.example.demo;

public class Book {

    private Long id;
    private String name;
    private String isbn;
    private String authorFirstName;
    private String authorLastName;
    private Integer bookCount;

    public Book(Long id, String name, String isbn, String authorFirstName, String authorLastName, Integer bookCount) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.bookCount = bookCount;
    }
}
