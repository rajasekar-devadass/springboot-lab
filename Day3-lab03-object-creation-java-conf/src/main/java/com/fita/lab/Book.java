package com.fita.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @PostConstruct
    public void initMethod() {
        System.out.println(
                "Inside init method"
        );
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println(
                "Inside destroy method"
        );
    }
}
