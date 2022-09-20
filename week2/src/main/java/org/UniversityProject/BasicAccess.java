package org.UniversityProject;

import java.util.List;
import java.util.Scanner;

public class BasicAccess {

    protected List<User> users;

    public BasicAccess(List<User> users){
        this.users = users;
        start();
    }

    protected void start(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("S. Display Students | T. Display Teachers |  X. Exit");
            System.out.print("Please enter your choice: ");
            char choice = scanner.next().toLowerCase().charAt(0);
            switch (choice) {
                case 's' -> displayStudents();
                case 't' -> displayTeachers();
                case 'x' -> {
                    System.out.println("\nLeaving the program now ...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    protected void displayStudents(){
        System.out.printf("  LIST OF STUDENTS:\n%-2s %-10s %-10s %-15s %-10s %-10s \n", "Id", "FirstName", "Lastname", "Date of Birth", "Age", "Group");
        for(User user : users ){
            if(user instanceof Student){
                System.out.printf("%-2d %-10s %-10s %-15s %-10d %-10s  %n", users.indexOf(user) + 1, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getAge(), ((Student) user).getGroup());
            }
        }
    }

    protected void displayTeachers(){
        System.out.printf("  LIST OF TEACHERS:\n%-2s %-10s %-10s %-15s %-10s \n", "Id", "FirstName", "Lastname", "Date of Birth", "Age");
        for(User user : users){
            if(user instanceof Teacher){
                System.out.printf("%-2d %-10s %-10s %-15s %-10d  %n", users.indexOf(user) + 1, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getAge());
            }
        }
    }

}
