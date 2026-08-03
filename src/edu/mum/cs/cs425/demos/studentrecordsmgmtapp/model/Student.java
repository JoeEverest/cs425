package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single Student record for the University.
 */
public class Student {

	// Data fields (instance variables)
	private String studentId;
	private String name;
	private LocalDate dateOfAdmission;

	// Formatter used when a Student is printed to the console.
	private static final DateTimeFormatter DATE_FORMATTER =
			DateTimeFormatter.ofPattern("MM/dd/yyyy");

	// Constructor 1: the default (no-argument) constructor.
	public Student() {
	}

	// Constructor 2: takes the studentId and the name only.
	public Student(String studentId, String name) {
		this.studentId = studentId;
		this.name = name;
	}

	// Constructor 3: takes all three data fields.
	public Student(String studentId, String name, LocalDate dateOfAdmission) {
		this.studentId = studentId;
		this.name = name;
		this.dateOfAdmission = dateOfAdmission;
	}

	// Getter (accessor) and Setter (mutator) methods.
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	@Override
	public String toString() {
		return String.format("Student{studentId=%s, name=%-8s, dateOfAdmission=%s}",
				studentId, name, dateOfAdmission.format(DATE_FORMATTER));
	}
}
