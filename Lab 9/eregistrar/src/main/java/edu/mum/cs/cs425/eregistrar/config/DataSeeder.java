package edu.mum.cs.cs425.eregistrar.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;

/**
 * Inserts a few sample students on startup, but only when the table is empty.
 */
@Component
public class DataSeeder implements CommandLineRunner {

	private final StudentRepository studentRepository;

	public DataSeeder(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void run(String... args) {
		if (studentRepository.count() > 0) {
			return;
		}
		studentRepository.save(new Student("000-61-0001", "Anna", "Lynn", "Smith",
				3.78, LocalDate.of(2019, 5, 12), "No"));
		studentRepository.save(new Student("000-61-0002", "Bob", null, "Galverston",
				2.87, LocalDate.of(2020, 1, 15), "Yes"));
		studentRepository.save(new Student("000-61-0003", "Erica", "Jane", "Cortez",
				3.45, LocalDate.of(2018, 9, 3), "Yes"));
	}
}
