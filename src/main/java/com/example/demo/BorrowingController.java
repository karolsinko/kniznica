package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingController {
    private List<Borrowing> borrowings;

    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }

    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowing(@RequestParam(required = false) String id){
            return borrowingService.getBorrowing(id);
    }

    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody Borrowing borrowing){
        return borrowingService.createBorrowing(borrowing)
    }
    @DeleteMapping("/api/borrowings{id}")
    public void deleteBorrowing(@PathVariable Integer id){
        borrowingService.deleteBorrowing(id);

    }


}
