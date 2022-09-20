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


    }

    private void studentDetailLoop(Student student){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("A. Add (update) Report | R. Display Reports | B. Back to main | X. Exit");
            System.out.print("Please enter your choice: ");
            char choice = scanner.next().toLowerCase().charAt(0);
            switch (choice) {
                case 'a' -> addNewMarks(student);
                case 'r' -> showResults();
                case 'x' -> {
                    System.out.println("\nLeaving the program now ...");
                    System.exit(0);
                }
                case 'b' -> start();
                default -> System.out.println("Invalid choice");
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
                User user = users.get(id - 1);
                if(user instanceof Student) {
                    showResultDetails((Student)user, id);
                    studentDetailLoop((Student)user);
                    return;
                }
            }
            System.out.println("Invalid id");
        }
    }

    private void showResultDetails(Student student, int id){

        System.out.println("Student Id: " + id);
        System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student Date of Birth: " + student.getDateOfBirth());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Group: " + student.getGroup());

        System.out.println("\n\n     COURSES\n");

        System.out.println("Student Java Mark: " + student.getJavaMark());
        System.out.println("Student CSharp Mark: " + student.getCSharpMark());
        System.out.println("Student Python Mark: " + student.getPythonMark());
        System.out.println("Student PHP Mark: " + student.getPHPMark());

        System.out.println("\n\n     RESULTS\n");

        System.out.println("Passed: " + student.getPassed());
        System.out.println("Retakes: " + student.getRetakes());

    }

    private void addNewMarks(Student student){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Java mark: ");
        int javaMark = scanner.nextInt();

        System.out.print("Enter CSharp mark: ");
        int cSharpMark = scanner.nextInt();

        System.out.print("Enter Python mark: ");
        int pythonMark = scanner.nextInt();

        System.out.print("Enter PHP mark: ");
        int phpMark = scanner.nextInt();

        student.setJavaMark(javaMark);
        student.setCSharpMark(cSharpMark);
        student.setPythonMark(pythonMark);
        student.setPHPMark(phpMark);
    }
}

