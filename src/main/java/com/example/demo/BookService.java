package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private static BookDto mapToBookDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();

        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setIsbn(bookEntity.getIsbn());
        bookDto.setAuthorFirstName(bookEntity.getAuthorFirstName());
        bookDto.setAuthorLastName(bookEntity.getAuthorLastName());
        bookDto.setBookCount(bookEntity.getBookCount());

        return bookDto;
    }

    @Transactional
    public List<BookDto> getBooks(String bookAuthor) {
        List<BookDto> book = new LinkedList<>();
        for (BookEntity b1 : bookRepository.findAll()) {
            BookDto b2 = mapToBookDto(b1);
            book.add(b2);
        }
        return book;
    }

    @Transactional
    public BookDto getBook(Long bookId) {
        Optional<BookEntity> byId = bookRepository.findById(bookId);
        if (byId.isPresent()) {
            return mapToBookDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setIsbn(bookDto.getIsbn());
        bookEntity.setAuthorFirstName(bookDto.getAuthorFirstName());
        bookEntity.setAuthorLastName(bookDto.getAuthorLastName());
        bookEntity.setBookCount(bookDto.getBookCount());

        this.bookRepository.save(bookEntity);

        return bookEntity.getId();
    }

    @Transactional
    public void updateBook(int bookId, BookDto bookDto) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {

            byId.get().setId(bookDto.getId());
            byId.get().setTitle(bookDto.getTitle());
            byId.get().setIsbn(bookDto.getIsbn());
            byId.get().setAuthorFirstName(bookDto.getAuthorFirstName());
            byId.get().setAuthorLastName(bookDto.getAuthorLastName());
            byId.get().setBookCount(bookDto.getBookCount());

        }
    }

    @Transactional
    public void deleteBook(int bookId) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            bookRepository.delete(byId.get());
        }
    }

}

