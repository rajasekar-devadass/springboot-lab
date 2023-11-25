import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        int TOTAL_NO_OF_STUDENTS = 3;
        //Student data structure
        int[] studentRollNoArr = new int[TOTAL_NO_OF_STUDENTS];
        String[] studentNamesArr = new String[TOTAL_NO_OF_STUDENTS];
        String[] studentAddressArr = new String[TOTAL_NO_OF_STUDENTS];

        int studentEntries = 0;

        //Books data structure
        int TOTAL_NO_OF_BOOKS = 30;
        int[] bookIdArr = new int[TOTAL_NO_OF_BOOKS];
        String[] bookNamesArr = new String[TOTAL_NO_OF_BOOKS];
        String[] bookAuthorArr = new String[TOTAL_NO_OF_BOOKS];

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
                        studentRollNoArr[studentEntries] = studentEntries;
                        System.out.println("Enter student Name");
                        studentNamesArr[studentEntries] = inputScanner.next();
                        System.out.println("Enter student Address");
                        studentAddressArr[studentEntries] = inputScanner.next();
                        studentEntries++;
                    } else {
                        System.out.println("Cannot Add student, Max limit reached");
                    }
                    break;
                }
                case 2: {
                    //Add Books
                    if (bookEntries < TOTAL_NO_OF_BOOKS) {
                        bookIdArr[bookEntries] = bookEntries;
                        System.out.println("Enter Book Title");
                        bookNamesArr[bookEntries] = inputScanner.next();
                        System.out.println("Enter Book Author");
                        bookAuthorArr[bookEntries] = inputScanner.next();
                        bookEntries++;
                    } else {
                        System.out.println("Cannot Add Book, Max limit reached");
                    }
                    break;
                }
                case 3: {
                    //Display students
                    for (int index = 0; index < studentEntries; index++) {
                        System.out.println();
                        System.out.println("Roll No: " + studentRollNoArr[index]);
                        System.out.println("Name: " + studentNamesArr[index]);
                        System.out.println("Address: " + studentAddressArr[index]);
                    }
                    System.out.println();
                    break;
                }
                case 4: {
                    //Display books
                    for (int index = 0; index < bookEntries; index++) {
                        System.out.println();
                        System.out.println("Title" + bookNamesArr[index]);
                        System.out.println("Book Id" + bookIdArr[index]);
                        System.out.println("Author" + bookAuthorArr[index]);
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("Enter rollNo to modify info ");
                    int studentRoll = inputScanner.nextInt();
                    System.out.println("which info to modify 1:name, 2:address");
                    int userUpdateChoice = inputScanner.nextInt();
                    switch (userUpdateChoice) {
                        case 1: {
                            studentNamesArr[studentRoll] = inputScanner.next();
                            break;
                        }
                        case 2: {
                            studentAddressArr[studentRoll] = inputScanner.next();
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
                            bookNamesArr[bookId] = inputScanner.next();
                            break;
                        }
                        case 2: {
                            bookAuthorArr[bookId] = inputScanner.next();
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
