package com.example.demo.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookInterface extends CrudRepository<BookEntity, Long>  {
}