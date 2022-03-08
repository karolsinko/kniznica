package com.example.demo;

public class BorrowedBook {
    private Long id;
    private String borrower;
    private Book book;
    private String borrowing;

    public Long getId(){return this.id;}

    public void setId(Long id){this.id=id;}

    public User getUser(){return this.borrower;}

    public void setUser(String borrower){this.borrower=borrower;}

    public Book getBook(){return this.book;}

    public void setBook(String book){this.book=book;}

    public boolean getBorrowing() { return borrowing;
    }

    public boolean setBorrowing(){this.borrowing=borrowing;}


}
