package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class MyRestApi {

    private List<Book> bookList;

    public MyRestApi() {
        this.bookList = new LinkedList<>();
    }

    @GetMapping(value = "/books")
    @ResponseBody
    public List<Book> getAll() {
        return bookList;
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public Book geBookById(@PathVariable int id) {
        for(Book book: bookList){
            if(book.getId() == id){
                return book;
            }
        }
//        for(int i=0; i<bookList.size(); i++){
//            Book book = bookList.get(i);
//            if(book.getId() == id){
//                return book;
//            }
//        }
        return null;
    }

    @GetMapping("/books/search") ///books/search?isbn=123
    @ResponseBody
    public Book getBookByISBN(@RequestParam("isbn") String isbn) {
        //TODO
        return null;
    }

    @PostMapping("/books")
    @ResponseBody
    public Book addBook(@RequestBody @Valid Book bookVar) {
//        int currCount = bookList.size();
//        bookVar.setId(currCount);
        bookList.add(bookVar);
        return bookVar;
    }
}
