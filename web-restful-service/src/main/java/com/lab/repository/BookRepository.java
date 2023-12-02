package com.lab.repository;

import com.lab.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<Long, Book> bookMap;

    public BookRepository() {
        this.bookMap = new HashMap<>();
    }

    public void insert(Book book) {
        long id = bookMap.size() + 1;
        book.setId(id);
        bookMap.put(book.getId(), book);
    }

    public Book findById(long id) {
        return bookMap.get(id);
    }

    public Book findByISBN(String isbn) {
        for (Book book : bookMap.values()) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll() {
        return bookMap.values().stream().toList();
    }
}
