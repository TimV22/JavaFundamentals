package org.UniversityProject;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdminAccess extends EditorAccess{

    public AdminAccess(List<User> users) {
        super(users);
    }

    protected void start(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("S. Display Students | T. Display Teachers | A. Add Students | R. Display Results | X. Exit");
            System.out.print("Please enter your choice: ");
            char choice = scanner.next().toLowerCase().charAt(0);
            switch (choice) {
                case 's' -> super.displayStudents();
                case 't' -> super.displayTeachers();
                case 'x' -> {
                    System.out.println("\nLeaving the program now ...");
                    System.exit(0);
                }
                case 'r' -> showResults();
                case 'a' -> addStudentOrTeacher();
                case 'd' -> deleteStudentOrTeacher();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addStudentOrTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("S. Add Student | T. Add Teacher");
        System.out.print("Please enter your choice: ");
        char choice = scanner.next().toLowerCase().charAt(0);
        switch (choice) {
            case 's' -> addStudent();
            case 't' -> addTeacher();
            case 'b' -> {}
            default -> System.out.println("Invalid choice");
        }
    }

    private void addTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.next());
        System.out.print("Enter password: ");
        String password = scanner.next();
        users.add(new Teacher(firstName, lastName, dateOfBirth, password));
    }

    private void deleteStudentOrTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("S. Delete Student | T. Delete Teacher");
        System.out.print("Please enter your choice: ");
        char choice = scanner.next().toLowerCase().charAt(0);
        switch (choice) {
            case 's' -> deleteStudent();
            case 't' -> deleteTeacher();
            case 'b' -> {}
            default -> System.out.println("Invalid choice");
        }
    }

    private void deleteStudent(){
        displayStudents();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's id: ");
        int id = scanner.nextInt();
        users.remove(id - 1);
    }

    private void deleteTeacher(){
        displayTeachers();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter teacher's id: ");
        int id = scanner.nextInt();
        users.remove(id - 1);
    }
}
