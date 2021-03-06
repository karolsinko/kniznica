package com.example.demo.Borrowings;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {
    private List<Borrowings> borrowings;

    private BorrowingsService borrowingsService;

    public BorrowingsController(BorrowingsService borrowingsService){
        this.borrowingsService = borrowingsService;
    }

    @GetMapping("/api/borrowings")
    public List<Borrowings> getBorrowings(@RequestParam(required = false) String borrowingId){
        return borrowingsService.getBorrowings(borrowingId);
    }

    @PostMapping("api/borrowings")
    public  List<Borrowings> createBorrowing(@RequestBody Borrowings borrowing){
        return borrowingsService.createBorrowing(borrowing);
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        borrowingsService.deleteBorrowing(borrowingId);
    }
}
