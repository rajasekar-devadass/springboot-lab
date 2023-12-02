package com.lab.controller;

import com.lab.domain.Book;
import com.lab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book geBookById(@PathVariable long id) {
        return bookService.getById(id);
    }

    @GetMapping("/books/search")
    public Book geBookById(@RequestParam("isbn") String isbn) {
        return bookService.getByIsbn(isbn);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book bookInfo) {
        bookService.add(bookInfo);
        return bookInfo;
    }

}
