package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingController {
    private List<BorrowedBook> borrowings;

    public BorrowingController(){
        this.borrowings = init();
    }

    private List<BorrowedBook> init(){
        List<BorrowedBook> borrowings = new ArrayList<>();
        BorrowedBook borrowing1 = new BorrowedBook();
        borrowing1.setId(1L);
        borrowing1.setUser("Jožko Mrkva");
        borrowing1.setBook("Recepty");
        borrowings.add(borrowing1);

        BorrowedBook borrowing2 = new BorrowedBook();
        borrowing2.setId(2L);
        borrowing1.setUser("Janko Nový");
        borrowing1.setBook("Encyklopedia");
        borrowings.add(borrowing2);
        return borrowings;
    }

    @GetMapping("/api/borrowings")
    public List<BorrowedBook> getBorrowings(@RequestParam(required = false) String BorrowedBook){
        if (BorrowedBook == null){
            return this.borrowings;
        }
        List<BorrowedBook> filteredBorrowings = new ArrayList<>();

        for(BorrowedBook borrowing : borrowings){
            if (borrowing.getBorrowing().equals(BorrowedBook)){
                filteredBorrowings.add(borrowing);
            }
        }
        return filteredBorrowings;

    }
    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowedBook getBorrowing(@PathVariable Integer borrowingId){
        return this.borrowings.get(borrowingId);

    }


    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody BorrowedBook borrowing){
        this.borrowings.add(borrowing);

        return this.borrowings.size() -1;
    }
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        this.borrowings.remove(this.borrowings.get(borrowingId));

    }
    @PutMapping("/api/borrowings/{borrowingId}")
    public void updateBorrowing(@PathVariable Integer borrowingId, @RequestBody BorrowedBook borrowing){
        this.borrowings.get(borrowingId).setBorrowing();
    }
}


