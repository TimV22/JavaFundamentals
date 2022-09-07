import java.util.Scanner;

public class assignment02 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // course name
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        // nr students
        System.out.print("Enter number of students: ");
        int nrStudents = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        // enter student names
        String[] students = new String[nrStudents];

        for (int i = 0; i < nrStudents; i++)
        {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            students[i] = scanner.nextLine();
        }

        System.out.println();

        // enter student grades
        int[] grades = new int[nrStudents];

        for (int i = 0; i < nrStudents; i++)
        {
            System.out.print("Enter grade of " + students[i] + ": ");
            grades[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println();

        // print average grade
        float sum = 0;
        for (int i = 0; i < nrStudents; i++)
        {
            sum += grades[i];
        }
        float average = sum / nrStudents;
        System.out.printf("Average grade: %.1f \n", average);

        // print maximum grade
        int max = grades[0];
        int studentIndex = 0;
        for (int i = 1; i < nrStudents; i++)
        {
            if (grades[i] > max)
            {
                max = grades[i];
                studentIndex = i;
            }
        }
        System.out.println("Student" + students[studentIndex] + "has maximum grade: " + max);

        System.out.println();

        // print grades of all students
        for (int i = 0; i < nrStudents; i++)
        {
            System.out.println("Grade for student " + students[i] + " (course " + courseName + ")" + ": " + grades[i]);
        }

    }
}
