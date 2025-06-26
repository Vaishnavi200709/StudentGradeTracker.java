/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== Student Grade Tracker =====");

        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter grade for " + name + ": ");
            double grade = sc.nextDouble();
            sc.nextLine(); // consume newline

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No students entered.");
            return;
        }

        // Variables for calculations
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "", bottomStudent = "";

        System.out.println("\n===== Summary Report =====");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.grade);
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                bottomStudent = s.name;
            }
        }

        double average = total / students.size();

        System.out.printf("\nAverage Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Score : " + lowest + " (by " + bottomStudent + ")");
    }
}
