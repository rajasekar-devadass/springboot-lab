package com.lab.service;

import com.lab.domain.Book;
import com.lab.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookRepository booksRepository;

    public void add(Book book) {
        booksRepository.insert(book);
    }

    public Book getByIsbn(String isbn) {
        return booksRepository.findByISBN(isbn);
    }

    public Book getById(long id) {
        return booksRepository.findById(id);
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }
}
