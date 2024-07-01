package src;

import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static String filePath = "src/data.txt";
    private static File myFile = new File(filePath);
    private static Scanner scanner = new Scanner(System.in);

    public StudentManager() {
    }

    public static void addStudent() throws IOException {
        FileWriter fileWriter = new FileWriter(myFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println("----------Enter student information------");
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        Student s = new Student(Integer.parseInt(id), name);
        String dataStudent = s.getId() + "," + s.getName();
        // luu vao file
        bufferedWriter.write(dataStudent);
        bufferedWriter.newLine();
        // dong file lai va du data luu lai
        bufferedWriter.close();
    }

    public static void showListStudent() throws IOException {
        FileReader fileReader = new FileReader(myFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            // chuyen String ve array su dung split()
            String[] data = line.split(",");
            int idStudent = Integer.parseInt(data[0]);
            String nameStudent = data[1];
            Student s1 = new Student(idStudent, nameStudent);
            System.out.println(s1);
        }
        bufferedReader.close();
    }


    public static void deleteStudent() throws IOException {

        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String line = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile));

        System.out.println("dien Id : ");

        int idStudent = scanner.nextInt();

        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            Student s1 = new Student(id, name);
            students.add(s1);
        }

        bufferedReader.close();

        for (Student item : students) {
            if (item.getId() == idStudent) {
                students.remove(item);
                break;
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(myFile));
        for (Student item : students) {
            bufferedWriter.write(item.getId() + "," + item.getName());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void fixStudent() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile));
        String line = "";
        System.out.println("nhap Id sinh vien can sua: ");
        int idStudent = scanner.nextInt();
        System.out.println("nhap ten moi: ");
        String newname = scanner.next();
        List<Student> students = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            Student s1 = new Student(id, name);
            students.add(s1);
        }
        bufferedReader.close();
        for (Student student : students) {
            if (student.getId() == idStudent) {
                student.setName(newname);
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(myFile));
        for (Student item : students) {
            bufferedWriter.write(item.getId() + "," + item.getName());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void importStudents() throws IOException {
        System.out.println("Nhap ten tep : ");
        String fileName = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                Student student = new Student(id, name);
                studentList.add(student);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FileWriter fileWriter = new FileWriter(myFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Student student : studentList) {
            bufferedWriter.write(student.getId() + "," + student.getName() + "\n");
        }
        bufferedWriter.close();
    }

    public static void exportStudents() throws IOException {
        System.out.println("Nhap ten tep : ");
        String fileName = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                Student student = new Student(id, name);
                studentList.add(student);
            }
            bufferedReader.close();
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentList) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "\n");
            }
            bufferedWriter.close();

    }
}