package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BorrowingEntity {
    @Id
    @GeneratedValue

    private String id;
    public String bookId;
    public String customerId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBookId() {
        this bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getCustomerId() {
        this customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


}

