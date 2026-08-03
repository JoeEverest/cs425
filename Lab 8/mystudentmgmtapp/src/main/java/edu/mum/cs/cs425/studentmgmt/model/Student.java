package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "student_number", nullable = false, unique = true)
	private String studentNumber;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	// middleName is optional, so the column is nullable.
	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	// cgpa is optional. A Double (object) is used so it can hold null.
	@Column(name = "cgpa")
	private Double cgpa;

	@Column(name = "date_of_enrollment")
	private LocalDate dateOfEnrollment;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transcript_id")
	private Transcript transcript;

	// Default (no-argument) constructor is required by JPA.
	public Student() {
	}

	public Student(Long studentId, String studentNumber, String firstName,
			String middleName, String lastName, Double cgpa,
			LocalDate dateOfEnrollment) {
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	@Override
	public String toString() {
		return String.format(
				"Student{studentId=%d, studentNumber=%s, firstName=%s, middleName=%s, "
						+ "lastName=%s, cgpa=%s, dateOfEnrollment=%s, transcript=%s}",
				studentId, studentNumber, firstName, middleName, lastName, cgpa,
				dateOfEnrollment, transcript);
	}
}
