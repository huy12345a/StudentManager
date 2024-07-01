import src.StudentManager;

import java.util.Scanner;

public class App {
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
                if (choice == 7) {
                    break;
                }
                switch (choice) {
                    case 1:
                        StudentManager.addStudent();
                        break;
                    case 2:
                        StudentManager.showListStudent();
                        break;
                    case 3:
                        StudentManager.deleteStudent();
                    case 4:
                        StudentManager.fixStudent();
                    case 5:
                        StudentManager.importStudents();
                    case 6:
                        StudentManager.exportStudents();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
