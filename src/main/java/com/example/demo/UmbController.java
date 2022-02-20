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

    private List<Book> init(){

        List<User> users = new ArrayList<>();
        user.setFirstName("a");
        user.setLastName("b");
        user.setContact("c");
        users.add(user);

        User user2 = new User();
        user.setFirstName("e");
        user.setLastName("f");
        user.setContact("g");
        users.add(user2);
        return users;

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
/*

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
        if (bookAuthor == null){
            return this.books;
        }
        List<Book> filteredBooks = new ArrayList<>();

        for(Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
*//*
    }
    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId){
        return this.books.get(bookId);
*//*
    }
    //@RequestParam(required = false) String lastname
    //@GetMapping("/api/books")
    //public Book queryBook(){
*//*
    //}
    @PostMapping("/api/books")
    public Integer createBook(@RequestBody Book book){
        this.books.add(book);

        return this.books.size() -1;
    }
    *//*
    @DeleteMapping("/api/books{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));

    }
    *//*
    @PutMapping("/api/books{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setAuthor(book.getAuthor());
    }
}

}*/