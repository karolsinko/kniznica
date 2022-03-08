package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowingController {
    private List<Borrowing> borrowings;

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }

    @GetMapping("/api/borrowings")
    public List<BorrowingDto> getBorrowings(@RequestParam(required = false) String id) {
        return borrowingService.getBorrowing(id);
    }

    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowing(@RequestParam(required = false) String id){
            return borrowingService.getBorrowing(id);
    }

    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody BorrowingDto borrowingDto){
        return borrowingService.createBorrowing(borrowingDto)
    }
    @DeleteMapping("/api/borrowings{id}")
    public void deleteBorrowing(@PathVariable Integer id){
        borrowingService.deleteBorrowing(id);

    }
    @PutMapping("/api/borrowings{id}")
    public void updateBorrowing(@PathVariable int id, @RequestBody BorrowingDto borrowingDto) {
        borrowingService.updateBorrowing(id, borrowingDto);
    }


}
