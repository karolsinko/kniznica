package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService {
    private List<Borrowing> borrowings;

    private BorrowingService borrowingService;

    public BorrowingController(){
        this.borrowings =init();
    }

    private List<Borrowing> init(){
        List<Borrowing> borrowing = new ArrayList<>();

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setId("1");
        borrowing1.setCustomerId("1");
        borrowing1.setBookId("3");

        borrowing.add(borrowing1);

        Borrowing borrowing2 = new Borrowing();
        borrowing2.setId("1");
        borrowing2.setCustomerId("1");
        borrowing2.setBookId("3");


        borrowing.add(borrowing2);

        return borrowing;
    }


    public List<Borrowing> getBorrowing( String id){
        if (id == null){
            return this.borrowings;
        }
        List<Book> filteredBorrowings = new ArrayList<>();

        for(Borrowing borrowings : borrowings){
            if (borrowings.getId().equals(id)){
                filteredBorrowings.add(borrowings);
            }
        }
        return filteredBorrowings;

    }

    public Integer createBorrowing(Borrowing borrowing){
        this.borrowings.add(borrowing);
        return borrowings;
    }

    public void deleteBorrowing( Integer id){
        this.borrowings.remove(this.borrowings.get(id));

    }
}
