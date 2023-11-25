package com.fita.lab;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BookController {
    private final int TOTAL_NO_OF_BOOKS;
    private Book[] bookArr;

    private int bookEntries = 0;

    public BookController() {
        this(30);
    }

    public BookController(int TOTAL_NO_OF_BOOKS) {
        this.TOTAL_NO_OF_BOOKS = TOTAL_NO_OF_BOOKS;
        bookArr = new Book[this.TOTAL_NO_OF_BOOKS];
    }

    public void manageBooks(Scanner inputScanner) {
        boolean isTerminate = false;
        while (!isTerminate) {
            System.out.println("Enter choice: 1.Add book, 2.Display books, 3.Modify book, 4.exit");
            int userChoice = inputScanner.nextInt();
            switch (userChoice) {
                case 1: {
                    //Add Books
                    if (bookEntries < TOTAL_NO_OF_BOOKS) {
                        System.out.println("Enter Book Title");
                        String title = inputScanner.next();
                        System.out.println("Enter Book Author");
                        String author = inputScanner.next();
                        Book book = new Book(bookEntries, title, author);
                        bookArr[bookEntries] = book;
                        bookEntries++;
                    } else {
                        System.out.println("Cannot Add Book, Max limit reached");
                    }
                    break;
                }
                case 2: {
                    //Display books
                    for (int index = 0; index < bookEntries; index++) {
                        System.out.println();
                        Book book = bookArr[index];
                        System.out.println(book.toString());
                    }
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("Enter BookId to modify info");
                    int bookId = inputScanner.nextInt();
                    System.out.println("which info to modify 1: title, 2:author");
                    int bookUpdateChoice = inputScanner.nextInt();
                    switch (bookUpdateChoice) {
                        case 1: {
                            String title = inputScanner.next();
                            Book book = bookArr[bookId];
                            book.setTitle(title);
                            break;
                        }
                        case 2: {
                            bookArr[bookId].setAuthor(inputScanner.next());
                            break;
                        }
                        default: {
                            System.out.println("Invalid choice");
                        }
                    }
                    break;
                }
                case 4: {
                    isTerminate = true;
                    System.out.println("Exiting the Book application");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}
