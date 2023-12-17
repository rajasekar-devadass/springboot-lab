package com.lab.repository;

import com.lab.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<String, Book> bookMap;

    public BookRepository() {
        this.bookMap = new HashMap<>();
    }

    public void insert(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public Book find(String isbn) {
        return bookMap.get(isbn);
    }

    public List<Book> findAll() {
        return bookMap.values().stream().toList();
    }
}
