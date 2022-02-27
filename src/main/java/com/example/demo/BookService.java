import com.example.demo.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books;

    public BookService(){
        this.books = init();
    }

    private List<Book> init(){
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthor("Arthur");
        book1.setTitle("Study in Red");

        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("J.R.R.");
        book2.setTitle("The Hobbit");

        books.add(book2);

        return books;
    }


    public List<Book> getBooks(String bookAuthor){
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

    }

    public Book getBook(Integer bookId){
        return this.books.get(bookId);

    }
    //@RequestParam(required = false) String lastname
    //@GetMapping("/api/books")
    //public Book queryBook(){

    //}

    public Integer createBook(Book book){
        this.books.add(book);
        return this.books.size() -1;
    }

    public void deleteBook(Integer bookId){
        this.books.remove(this.books.get(bookId));

    }

    public void updateBook(Integer bookId, Book book){
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setAuthor(book.getAuthor());
    }

}

