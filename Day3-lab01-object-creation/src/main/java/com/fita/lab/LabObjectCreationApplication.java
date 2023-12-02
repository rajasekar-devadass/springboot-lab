package com.fita.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LabObjectCreationApplication implements CommandLineRunner {

	@Autowired
	public StudentController studentControllerObj;

	@Autowired
	public BookController bookControllerObj;

	public static void main(String[] args) {
		SpringApplication.run(LabObjectCreationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner inputScanner = new Scanner(System.in);

//		StudentController studentController = new StudentController(TOTAL_NO_OF_STUDENTS);
//		BookController bookController = new BookController(TOTAL_NO_OF_BOOKS);

		boolean isTerminate = false;
		while (!isTerminate) {
			System.out.println("Enter choice: 1.Manage student, 2.Manage book, 3.exit");
			int userChoice = inputScanner.nextInt();
			switch (userChoice) {
				case 1: {
					studentControllerObj.manageStudent(inputScanner);
					break;
				}
				case 2: {
					bookControllerObj.manageBooks(inputScanner);
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
