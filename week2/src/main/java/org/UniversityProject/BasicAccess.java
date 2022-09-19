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
            switch (choice){
                case 's':
                    displayStudents();
                    break;
                case 't':
                    displayTeachers();
                    break;
                case 'x':
                    System.out.println("\nLeaving the program now ...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    protected void displayStudents(){
        System.out.printf("  LIST OF STUDENTS:\n%-2s %-10s %-10s %-15s %-10s %-10s \n", "Id", "FirstName", "Lastname", "Date of Birth", "Age", "Group");
        int counter = 0;
        for(User user : users ){
            if(user instanceof Student){
                counter++;
                System.out.printf("%-2d %-10s %-10s %-15s %-10d %-10s  %n", counter, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getAge(), ((Student) user).getGroup());
            }
        }
    }

    protected void displayTeachers(){
        System.out.printf("  LIST OF TEACHERS:\n%-2s %-10s %-10s %-15s %-10s \n", "Id", "FirstName", "Lastname", "Date of Birth", "Age");
        int counter = 0;
        for(User user : users){
            if(user instanceof Teacher){
                System.out.printf("%-2d %-10s %-10s %-15s %-10d  %n", counter, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getAge());
            }
        }
    }

}