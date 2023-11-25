import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int TOTAL_NO_OF_STUDENTS = 3;
        int TOTAL_NO_OF_BOOKS = 30;

        Scanner inputScanner = new Scanner(System.in);

        StudentController studentController = new StudentController(TOTAL_NO_OF_STUDENTS);
        BookController bookController = new BookController(TOTAL_NO_OF_BOOKS);

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