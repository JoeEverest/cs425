package edu.mum.cs.cs425.eregistrar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;

/**
 * Business-logic layer for Student operations.
 */
@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudentById(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	// Extra credit: search across student number, first name, and last name.
	public List<Student> searchStudents(String keyword) {
		if (keyword == null || keyword.isBlank()) {
			return getAllStudents();
		}
		return studentRepository
				.findByStudentNumberContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
						keyword, keyword, keyword);
	}
}
