package com.fita.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Scanner;

@Configuration
@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class LabObjectCreationXmlApplication implements CommandLineRunner {

//	@Autowired
//	public StudentController studentController;

//	@Autowired
//	public BookController bookController;

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(LabObjectCreationXmlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner inputScanner = new Scanner(System.in);

//        StudentController studentController = new StudentController(TOTAL_NO_OF_STUDENTS);
//        BookController bookController = new BookController(TOTAL_NO_OF_BOOKS);

        StudentController studentController = context.getBean(StudentController.class);
        BookController bookController = context.getBean(BookController.class);

        boolean isTerminate = false;
        while (!isTerminate) {
            System.out.println("Enter choice: 1.Manage student, 2.Manage book, 3.exit");
            int userChoice = inputScanner.nextInt();
            switch (userChoice) {
                case 1: {
                    studentController.manageStudent(inputScanner);
                    break;
                }
                case 2: {
                    bookController.manageBooks(inputScanner);
                    break;
                }
                case 3: {
                    isTerminate = true;
                    System.out.println("Exiting the Main application");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        }

    }
}
