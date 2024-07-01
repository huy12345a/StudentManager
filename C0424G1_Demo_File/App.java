import src.StudentManager;

import java.util.Scanner;

public class App {

    public static final int EXIT_CHOICE = 7;
    public static final int ADD_STUDENT = 1;
    public static final int SHOW_LIST_STUDENT = 2;
    public static final int DELETE_STUDENT = 3;
    public static final int UPDATE_STUDENT = 4;
    public static final int IMPORT_STUDENT = 5;
    public static final int EXPORT_STUDENT = 6;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("----Enter choice number----");
                System.out.println("1: Add student");
                System.out.println("2: Show list students");
                System.out.println("3: Delete students");
                System.out.println("4: Update students");
                System.out.println("5: Import students");
                System.out.println("6: Export students");
                System.out.println("7: Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == EXIT_CHOICE) {
                    break;
                }
                switch (choice) {
                    case ADD_STUDENT:
                        StudentManager.addStudent(scanner);
                        break;
                    case SHOW_LIST_STUDENT:
                        StudentManager.showListStudent();
                        break;
                    case DELETE_STUDENT:
                        StudentManager.deleteStudent(scanner);
                    case UPDATE_STUDENT:
                        StudentManager.updateStudent(scanner);
                    case IMPORT_STUDENT:
                        StudentManager.importStudents(scanner);
                    case EXPORT_STUDENT:
                        StudentManager.exportStudents(scanner);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
