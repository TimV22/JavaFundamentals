import java.util.Scanner;

public class assignment03 {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            // Get the number of students
            System.out.println("Please enter the size of your group and press [ENTER]");
            int groupSize = scanner.nextInt();

            System.out.println("group size: " + groupSize);

            Student[] students = new Student[groupSize];
            System.out.println();

            //loop for student names
            for (int i = 0; i < groupSize; i++) {
                System.out.println("Please enter the name of student #" + (i+1) + " and press [ENTER]");
                students[i] = new Student(scanner.next());
            }

            System.out.println();

            //print all students
            for (int i = 0; i < groupSize; i++) {
                System.out.println("Student #" + (i+1) + ": " + students[i].name);
            }
            System.out.println();

            //loop for student attendance
            for (int i = 0; i < groupSize; i++) {
                System.out.println("Is student #" + (i+1) + "(" + students[i].name + ") present? [Y/N + ENTER]:");
                String present = scanner.next();
                students[i].present = present.equals("y");
            }

            System.out.println();

            //print attendance
            for (int i = 0; i < groupSize; i++) {
                System.out.println("Student #" + (i+1) + ": " + students[i].name + "      Present: " + students[i].present);
            }
        }
}

