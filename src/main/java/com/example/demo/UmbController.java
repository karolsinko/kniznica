package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UmbController {
    private List<Book> books;
    private List<User> users;

    public UmbController(){
        this.books = init();
        this.users = init();
    }

    private List<User> init(){

        List<User> users = new ArrayList<>();
        user.setFirstName("a");
        user.setLastName("b");
        user.setEmail("c");
        users.add(user);

        User user2 = new User();
        user2.setFirstName("e");
        user2.setLastName("f");
        user2.setEmail("g");
        users.add(user2);
        return users;

    }

    private List<Book> init(){
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.id("w");
        book.authorFirstName("Peter");
        book.authorLastName("Lynch");
        book.name("One up on Wall Street");
        book.isbn("ISBN12A69C");
        book.bookCount("10");
        books.add(book);

        Book book2 = new Book();
        book2.id("q");
        book2.authorFirstName("x");
        book2.authorLastName("y");
        book2.name("z");
        book2.isbn("t");
        book2.bookCount("1");
        books.add(book2);
        return books;
    }
    @PostMapping("/api/customers")
    public Integer createUser(@RequestBody User user){
        this.users.add(user);

        return this.users.size() -1;
    }
    @GetMapping("/api/customers/{id}")
    public User getUser(@PathVariable Integer id){
        return this.users.get(id);

    }

    }

    @DeleteMapping("/api/customers/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.users.remove(this.users.get(id));

    }

    @PutMapping("/api/customers/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user){
        this.users.get(id).setFirstName(user.getFirstName());
        this.users.get(id).setLastName(user.getLastName());
        this.users.get(id).setEmail(user.getEmail());
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
        if (bookAuthor == null){
            return this.books;
        }
        List<Book> filteredBooks = new ArrayList<>();

        for(Book book : books){
            if (book.getAuthorFirstName().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;

    }
    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId){
        return this.books.get(bookId);

    }

    @PostMapping("/api/books")
    public Integer createBook(@RequestBody Book book){
        this.books.add(book);

        return this.books.size() -1;
    }
    @DeleteMapping("/api/books{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));

    }
    @PutMapping("/api/books{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        //TODO
    }
}


