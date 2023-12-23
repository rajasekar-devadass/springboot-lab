package com.lab.controller;

import com.lab.domain.Book;
import com.lab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("books", bookService.findAll());
//        model.addAttribute("user", userService.findAll());
        return "books/allBooks";
    }

    @GetMapping("/addBookFormAction")
    public String getAddBookForm(Model model) {
        model.addAttribute("bookInfo", new Book());
        return "books/addBookForm";
    }

    @PostMapping("/saveBooks")
    public String addBook(Model model, @ModelAttribute Book bookInfo) {
        bookService.add(bookInfo);
        return "redirect:/books";
    }

}
