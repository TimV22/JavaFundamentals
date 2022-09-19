package org.UniversityProject;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EditorAccess extends BasicAccess {

    public EditorAccess(List<User> users) {
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
                case 'a' -> addStudent();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    protected void addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.next());
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Enter group: ");
        String group = scanner.next();
        Student student = new Student(firstName, lastName, dateOfBirth, password, group);
        users.add(student);
        System.out.println("Student added successfully");
    }

    protected void showResults(){
        System.out.printf("  LIST OF RESULTS:\n%-2s %-10s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s \n",
                "Id", "FirstName", "Lastname", "Date of Birth", "Age", "Group", "Java", "CSharp", "Python", "PHP");
        int counter = 0;
        for(User user : users ){
            counter++;
            if(user instanceof Student){
                System.out.printf("%-2d %-10s %-10s %-15s %-10d %-10s %-10d %-10d %-10d %-10d %n",
                        counter, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getAge(), ((Student) user).getGroup(),
                        ((Student) user).getJavaMark(), ((Student) user).getCSharpMark(), ((Student) user).getPythonMark(), ((Student) user).getPHPMark());
            }
        }
        getStudentId();

        studentDetailLoop();
    }

    private void studentDetailLoop() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("A. Add (update) Report | R. Display Reports | B. Back to main | X. Exit");
            System.out.print("Please enter your choice: ");
            char choice = scanner.next().toLowerCase().charAt(0);
            switch (choice){
                case 'a':
                    //TODO add add/update report
                    break;
                case 'r':
                    showResults();
                    break;
                case 'x':
                    System.out.println("\nLeaving the program now ...");
                    System.exit(0);
                    break;
                case 'b':
                    start();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    }
    private void getStudentId(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter student id for result details: | Or 0 back to main menu: ");
            int id = scanner.nextInt();
            if (id == 0){
                return;
            }
            if(id > 0 && id <= users.size()){
                showResultDetails(id);
                return;
            }
            System.out.println("Invalid id");
        }
    }

    private void showResultDetails(int id){
        User user = users.get(id - 1);
        if(user instanceof Student){

            System.out.println("Student Id: " + id);
            System.out.println("Student Name: " + user.getFirstName() + " " + user.getLastName());
            System.out.println("Student Date of Birth: " + user.getDateOfBirth());
            System.out.println("Student Age: " + user.getAge());
            System.out.println("Student Group: " + ((Student) user).getGroup());

            System.out.println("\n\n     COURSES\n");

            System.out.println("Student Java Mark: " + ((Student) user).getJavaMark());
            System.out.println("Student CSharp Mark: " + ((Student) user).getCSharpMark());
            System.out.println("Student Python Mark: " + ((Student) user).getPythonMark());
            System.out.println("Student PHP Mark: " + ((Student) user).getPHPMark());

            System.out.println("\n\n     RESULTS\n");

            System.out.println("Result: " + ((Student) user).getResult());
            System.out.println("Retakes: " + ((Student) user).getRetakes());
        }

    }
}

