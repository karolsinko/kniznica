package com.example.demo.Book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookController {
    private List<Book> books;

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
        return bookService.getBooks(bookAuthor);
    }

    @GetMapping("/api/book/{bookId}") //search by {bookId}
    public Book getBook(@PathVariable Integer bookId){
        return this.bookService.getBook(bookId);
    }

    @GetMapping("/api/id") //search by bookId
    public List<Book> getBookId(@RequestParam(required = false) String bookId){
        return bookService.getBookId(bookId);
    }

    @GetMapping("/api/isbn") //search by bookIsbn
    public List<Book> getBookIsbn(@RequestParam(required = false) String bookIsbn){
        return bookService.getBookIsbn(bookIsbn);
    }

    @PostMapping("/api/books") //create new book
    public List<Book> createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.bookService.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}") //update by {book}
    public List<Book> putBook(@PathVariable Integer bookId, @RequestBody Book book){
        return this.bookService.putBook(bookId, book);
    }
}
