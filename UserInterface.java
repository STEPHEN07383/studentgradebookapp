package studentGradebookApp;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        Gradebook g1 = new Gradebook();
        Scanner scanner = new Scanner(System.in);

        // Adding students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student ID for student " + (i + 1) + ": ");
            int studentId = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Enter student name for student " + (i + 1) + ": ");
            String studentName = scanner.nextLine();

            Student student = new Student(studentId, studentName);
            g1.addStudent(student);
        }

		// Adding courses
		System.out.print("Enter course ID: ");
		int courseId = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Enter course name: ");
		String courseName = scanner.nextLine();

		Course course1 = new Course(courseId, courseName);
		g1.addCourse(course1);

		// Assigning grades
		System.out.print("Enter student ID to assign grade: ");
		int studentId = scanner.nextInt();

		System.out.print("Enter course ID to assign grade: ");
		courseId = scanner.nextInt();

		System.out.print("Enter grade: ");
		int grade = scanner.nextInt();

		g1.assignGrade(studentId, courseId, grade);

		// Displaying student grades
		System.out.print("Enter student ID to display grades: ");
		studentId = scanner.nextInt();

		g1.displayStudentGrades(studentId);

		scanner.close();
	}
}
