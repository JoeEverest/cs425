package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;


@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

	private final StudentRepository studentRepository;

	// Spring injects the repository through this constructor.
	public StudentMgmtApp(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}

	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void run(String... args) {
		// Create the sample Student s1.
		Student s1 = new Student(1L, "000-61-0001", "Anna", "Lynn", "Smith",
				3.45, LocalDate.of(2019, 5, 24));

		// Task 2.1: create the Transcript and link it to the Student (One-to-One).
		Transcript t1 = new Transcript(1L, "BS Computer Science");
		s1.setTranscript(t1);

		// Save the student; CascadeType.ALL saves the linked transcript too.
		saveStudent(s1);

		System.out.println("Saved student (with transcript) to the database:");
		System.out.println("  " + s1);
	}
}
