package com.example.demo;

public class BorrowedBook {

    private Long id;
    private User borrower;
    Book book = new Book();

    public BorrowedBook(Long id, User borrower, Book book) {
        this.id = id;
        this.borrower = borrower;
        this.book = book;
    }
}
