package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    private static BorrowingDto mapToBorrowingDto(BorrowingEntity borrowingEntity) {
        BorrowingDto borrowingDto = new BorrowingDto();

        borrowingDto.setBookId(borrowingEntity.getBookId());
        borrowingDto.setCustomerId(borrowingEntity.getCustomerId());

        return borrowingDto;
    }
    

    @Transactional
    public List<BorrowingDto> getBorrowings(String borrowwingId) {
        List<BorrowingDto> ret = new LinkedList<>();
        for (BorrowingEntity b1 : borrowingRepository.findAll()) {
            BorrowingDto b2 = mapToBorrowingDto(b1);
            ret.add(b2);
        }
        return ret;
    }

    @Transactional
    public BorrowingDto getBorrowing(Long id) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById(id);
        if (byId.isPresent()) {
            return mapToBorrowingDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createBorrowing(BorrowingDto borrowingDto) {
        BorrowingEntity borrowingEntity = new BorrowingEntity();

        borrowingEntity.setBookId(borrowingDto.getBookId());
        borrowingEntity.setCustomerId(borrowingDto.getCustomerId());

        this. borrowingRepository.save( borrowingEntity);

        return  borrowingEntity.getId();

    }

    @Transactional
    public void updateBorrowing(int id,BorrowingDto borrowingDto) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById((long)id);
        if (byId.isPresent()) {
            byId.get().setBookId(borrowingDto.getBookId());
            byId.get().setCustomerId(borrowingDto.getCustomerId());
        }
    }

    @Transactional
    public void deleteBorrowing(int id) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById((long)id);
        if (byId.isPresent()) {
            borrowingRepository.delete(byId.get());
        }
    }

}
