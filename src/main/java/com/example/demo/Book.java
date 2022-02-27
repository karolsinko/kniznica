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
    //ID knihy
    public String getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    //Meno knihy
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    //Krstne meno autora
    public String getAuthorFirstName(){
        return authorFirstName;
    }
    public void setAuthorFirstName(){
        this.authorFirstName = authorFirstName;
    }
    //Priezvisko autora
    public String getAuthorLastName(){
        return authorLastName;
    }
    public void setAuthorLastName(){
        this.authorLastName = authorLastName;
    }
    //ISBN knihy
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(){
        this.isbn = isbn;
    }
    //Pocet knih
    public String getBookCount(){
        return bookCount;
    }
    public void getBookCount(){
        this.bookCount = bookCount;
    }
}
}
