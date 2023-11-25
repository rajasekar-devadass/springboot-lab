package com.fita.lab;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StudentController {
    private final int TOTAL_NO_OF_STUDENTS;
    private Student[] studentArr;
    private int studentEntries = 0;

    public StudentController() {
        this(3);
    }

    public StudentController(int totalNoOfStudents) {
        this.TOTAL_NO_OF_STUDENTS = totalNoOfStudents;
        studentArr = new Student[TOTAL_NO_OF_STUDENTS];
    }

    public void manageStudent(final Scanner inputScanner) {
        boolean continueExecution = true;
        while (continueExecution) {
            System.out.println("Enter choice: 1.Add student, 2.Display students, 3. Modify student, 4.exit");
            int userChoice = inputScanner.nextInt();
            switch (userChoice) {
                case 1: {
                    //Add Students
                    addStudent(inputScanner);
                    break;
                }
                case 2: {
                    displayStudents();
                    break;
                }
                case 3: {
                    editStudent(inputScanner);
                    break;
                }
                case 4: {
                    continueExecution = false;
                    System.out.println("Exiting the Student Menu");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }

    private void addStudent(Scanner inputScanner) {
        if (studentEntries < TOTAL_NO_OF_STUDENTS) {
            System.out.println("Enter student Name");
            String name = inputScanner.next();
            System.out.println("Enter student city");
            String city = inputScanner.next(); //
            Address address = new Address(city);
            address.setCity(city);
            studentArr[studentEntries] = new Student(studentEntries, name, address);
            studentEntries++;
        } else {
            System.out.println("Cannot Add student, Max limit reached");
        }
    }

    private void editStudent(Scanner inputScanner) {
        System.out.println("Enter rollNo to modify info ");
        int studentRoll = inputScanner.nextInt();
        System.out.println("which info to modify 1:name, 2:address city");
        int userUpdateChoice = inputScanner.nextInt();
        switch (userUpdateChoice) {
            case 1: {
                String name = inputScanner.next();
                Student student = studentArr[studentRoll];
                student.setName(name);
                break;
            }
            case 2: {
                String city = inputScanner.next();
                studentArr[studentRoll].getAddress().setCity(city);
                break;
            }
            default: {
                System.out.println("Invalid choice");
            }
        }
    }

    private void displayStudents() {
        //Display students
        for (int index = 0; index < studentEntries; index++) {
            //studentArr[index].toString();
            Student student = studentArr[index];
            System.out.println(student.toString());
        }
        System.out.println();
    }
}
