package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

/**
 * Executable application that manages the University Student records.
 */
public class MyStudentRecordsMgmtApp {

	// A student is a PlatinumAlumni if admission was at least this many years ago.
	private static final int PLATINUM_ALUMNI_YEARS = 30;

	public static void main(String[] args) {

		// Create an array of Students using the sample data provided.
		Student[] students = {
				new Student("110001", "Dave", LocalDate.of(1951, 11, 18)),
				new Student("110002", "Anna", LocalDate.of(1990, 12, 7)),
				new Student("110003", "Erica", LocalDate.of(1974, 1, 31)),
				new Student("110004", "Carlos", LocalDate.of(2009, 8, 22)),
				new Student("110005", "Bob", LocalDate.of(1990, 3, 5))
		};

		// Print all students in ascending order of their names.
		printListOfStudents(students);

		// Get and print the PlatinumAlumni students in descending order of
		// their dates of admission.
		List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);

		System.out.println();
		System.out.println("List of PlatinumAlumni students "
				+ "(descending order of date of admission):");
		System.out.println("-------------------------------------------------"
				+ "-------------------------");
		platinumAlumni.stream()
				.sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
				.forEach(System.out::println);
	}

	/**
	 * Iterates through the array of students and prints all the student data to
	 * the console, in ascending order of the students' names.
	 */
	public static void printListOfStudents(Student[] students) {
		System.out.println("List of all students (ascending order of name):");
		System.out.println("-------------------------------------------------"
				+ "-------------------------");
		Arrays.stream(students)
				.sorted(Comparator.comparing(Student::getName))
				.forEach(System.out::println);
	}

	/**
	 * Returns a List of only the PlatinumAlumni students. A PlatinumAlumni
	 * student gained admission at least 30 years ago.
	 */
	public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
		List<Student> platinumAlumni = new ArrayList<>();
		LocalDate today = LocalDate.now();

		for (Student student : students) {
			int yearsSinceAdmission =
					Period.between(student.getDateOfAdmission(), today).getYears();
			if (yearsSinceAdmission >= PLATINUM_ALUMNI_YEARS) {
				platinumAlumni.add(student);
			}
		}
		return platinumAlumni;
	}
}
