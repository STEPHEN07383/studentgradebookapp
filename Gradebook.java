package studentGradebookApp;

import java.util.*;
public class Gradebook {

	private Map<Integer, Student> students;
	private Map<Integer, Course> courses;
    private Map<Integer, Map<Integer, Integer>> grades;

    public Gradebook() {
        students = new HashMap<>();
        courses = new HashMap<>();
        grades = new HashMap<>();
    }
    
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void addCourse(Course course) {
        courses.put(course.getId(), course);
    }

    public void assignGrade(int studentId, int courseId, int grade) {
        if (students.containsKey(studentId) && courses.containsKey(courseId)) {
            Map<Integer, Integer> studentGrades = grades.getOrDefault(studentId, new HashMap<>());
            studentGrades.put(courseId, grade);
            grades.put(studentId, studentGrades);
        }
    }

    public void displayStudentGrades(int studentId) {
        if (students.containsKey(studentId)) {
            Student student = students.get(studentId);
            System.out.println("Grades for " + student.getName() + ":");
            Map<Integer, Integer> studentGrades = grades.getOrDefault(studentId, new HashMap<>());
            for (Map.Entry<Integer, Integer> entry : studentGrades.entrySet()) {
                int courseId = entry.getKey();
                int grade = entry.getValue();
                Course course = courses.get(courseId);
                System.out.println(course.getCourseName() + ": " + grade);
            }
        } else {
            System.out.println("Student not found!");
        }
    }
}
