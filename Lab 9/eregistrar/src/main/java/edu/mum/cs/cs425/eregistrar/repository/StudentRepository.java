package edu.mum.cs.cs425.eregistrar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.eregistrar.model.Student;

/**
 * Spring Data JPA repository for Student entities.
 * Provides CRUD operations plus a search across name and student number.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

	// Extra credit: search by student number, first name, or last name (case-insensitive).
	List<Student> findByStudentNumberContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
			String studentNumber, String firstName, String lastName);
}
