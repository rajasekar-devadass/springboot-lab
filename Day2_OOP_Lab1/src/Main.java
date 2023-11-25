import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int TOTAL_NO_OF_STUDENTS = 3;
        int TOTAL_NO_OF_BOOKS = 30;

        //Student data structure
        Student[] studentArr = new Student[TOTAL_NO_OF_STUDENTS];
        Book[] bookArr = new Book[TOTAL_NO_OF_STUDENTS];

        int studentEntries = 0;
        int bookEntries = 0;

        Scanner inputScanner = new Scanner(System.in);

        boolean isTerminate = false;
        while (!isTerminate) {
            System.out.println("Enter choice: 1.Add student, 2.Add book, 3.Display students 4.Display books, 5. Modify student, 6. Modify book, 7.exit");
            int userChoice = inputScanner.nextInt();
            switch (userChoice) {
                case 1: {
                    //Add Students
                    if (studentEntries < TOTAL_NO_OF_STUDENTS) {
                        System.out.println("Enter student Name");
                        String name = inputScanner.next();
                        System.out.println("Enter student city");
                        String city = inputScanner.next();
                        Address address = new Address(city);
                        studentArr[studentEntries] = new Student(studentEntries, name, address);
                        studentEntries++;
                    } else {
                        System.out.println("Cannot Add student, Max limit reached");
                    }
                    break;
                }
                case 2: {
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
                case 3: {
                    //Display students
                    for (int index = 0; index < studentEntries; index++) {
//                        studentArr[index].toString();
                        Student student = studentArr[index];
                        System.out.println(student.toString());
                    }
                    System.out.println();
                    break;
                }
                case 4: {
                    //Display books
                    for (int index = 0; index < bookEntries; index++) {
                        System.out.println();
                        Book book = bookArr[index];
                        System.out.println(book.toString());
                    }
                    System.out.println();
                    break;
                }
                case 5: {
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
                    break;
                }
                case 6: {
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
                case 7: {
                    isTerminate = true;
                    System.out.println("Exiting the application");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }

            }
        }
    }
}