package com.example.demo.Book;

import com.example.demo.Book.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books;

    public BookService(){
        this.books = init();
    }

    public List<Book> init() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthor("a");
        book1.setTitle("b");
        book1.setIsbn("v");
        book1.setId("d");
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("aa");
        book2.setTitle("bb");
        book2.setIsbn("cc");
        book2.setId("dd");
        books.add(book2);

        return books;
    }

    public List<Book> getBooks(String bookAuthor){
        if (bookAuthor == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    public Book getBook(int bookId){
        return this.books.get(bookId);
    }

    public List<Book> getBookId(String bookId){
        if (bookId == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getId().equals(bookId)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    public List<Book> getBookIsbn(String bookIsbn){
        if (bookIsbn == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getIsbn().equals(bookIsbn)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    public List<Book> createBook(Book book){
        this.books.add(book);
        return books;
    }

    public void deleteBook(int bookId){
        this.books.remove(this.books.get(bookId));
    }

    public List<Book> putBook(int bookId, Book book){
        this.books.get(bookId).setId(book.getId());
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setIsbn(book.getIsbn());
        return books;
    }
}