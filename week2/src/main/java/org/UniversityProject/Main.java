package org.UniversityProject;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<User> users = Collections.emptyList();

    public static void main(String[] args) {
        Main main = new Main();
        main.Start();
    }

    private void Start(){
        loadAllUsers();
        System.out.println("Welcome to the University Project");
        while(true){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Please enter your name: ");
            String name = scanner.next();

            System.out.print("Please enter your password: ");
            String password = scanner.next();

            User user = checkUser(name, password);
            if(user == null){
                System.out.println("User not found");
            }else{
                System.out.println("\nWelcome " + user.getFirstName() + " " + user.getLastName());
                if(user instanceof Student){
                    System.out.println("You are a student");
                    new BasicAccess(users);
                }else if(user instanceof Teacher){
                    System.out.println("You are a teacher");
                    new EditorAccess(users);
                }else if(user instanceof Manager){
                    System.out.println("You are a manager");
                }
                break;
            }
        }
    }

    private User checkUser(String name, String password){
        for(User user : users){
            if(user.getFirstName().toLowerCase().equals(name.toLowerCase()) && user.checkPassword(password)){
                return user;
            }
        }
        return null;
    }

    private void loadAllUsers(){
        List<User> users = new java.util.ArrayList<>(Collections.emptyList());
        
        //Students
        users.add(new Student("Emma", "Smith", LocalDate.of(1997, 12, 4), "emma12", "IT-02-A", 54, 50, 66, 54));
        users.add(new Student("Jack", "Brown", LocalDate.of(1993, 8, 7), "jack12", "IT-02-A", 72, 68, 43, 95));
        users.add(new Student("Micheal", "Garcia", LocalDate.of(1999, 11, 1), "micheal12", "IT-02-A", 45, 71, 55, 84));
        users.add(new Student("Lisa", "Jones", LocalDate.of(2000, 4, 29), "lisa12", "IT-02-A", 98, 64, 81, 72));
        users.add(new Student("John", "Miller", LocalDate.of(2001, 10, 27), "john12", "IT-02-A", 100, 94, 99, 93));
        users.add(new Student("Linda", "Martinez", LocalDate.of(2002, 1, 17), "linda12", "IT-02-A", 55, 79, 81, 55));
        users.add(new Student("Richard", "Davis", LocalDate.of(1997, 9, 22), "richard12", "IT-02-A", 51, 64, 39, 59));
        users.add(new Student("Mark", "Lopez", LocalDate.of(1996, 12, 9), "mark12", "IT-02-A", 78, 98, 89, 99));
        users.add(new Student("Debora", "Hernandez", LocalDate.of(1995, 2, 25), "debora12", "IT-02-A", 59, 55, 67, 99));
        users.add(new Student("Rick", "Moore", LocalDate.of(2000, 3, 16), "rick12", "IT-02-A", 96, 87, 55, 82));

        //teachers
        users.add(new Teacher("David", "Taylor", LocalDate.of(1965, 6, 15), "david123"));
        users.add(new Teacher("Sophy", "Anderson", LocalDate.of(1987, 1, 6), "sophy123"));
        users.add(new Teacher("James", "Jordon", LocalDate.of(1956, 3, 19), "james123"));
        users.add(new Teacher("Susan", "Jackson", LocalDate.of(1978, 12, 25), "susan123"));
        users.add(new Teacher("Mary", "Lee", LocalDate.of(1971, 9, 4), "mary123"));

        //managers
        users.add(new Manager("John", "Smith", LocalDate.of(1980, 12, 12), "john1234"));

        this.users = users;
    }


}