package com.example.demo;

public class BorrowedBook {
    private Long id;
    private User borrower;
    private Book book;

    public Long getId(){return this.id;}

    public void setId(Long id){this.id=id;}

    public User getUser(){return this.borrower;}

    public void setUser(User borrower){this.borrower=borrower;}

    public Book getBook(){return this.book;}

    public void setBook(Book book){this.book=book;}

    public boolean getBorrowing() { return false;
    }

    public boolean setBorrowing(){return true;}
}
