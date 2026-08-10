package edu.mum.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import jakarta.validation.Valid;

/**
 * Web MVC controller for the eRegistrar application. Implements the five
 * use-cases: home, list, register (create), edit (update), delete, plus search.
 */
@Controller
@RequestMapping("/eregistrar")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// Use-case 1: Homepage.
	@GetMapping({ "", "/", "/home" })
	public String home() {
		return "home";
	}

	// Use-case 2: Display list of all students.
	@GetMapping("/student/list")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "student/list";
	}

	// Use-case 3: Show the empty registration form.
	@GetMapping("/student/new")
	public String showRegisterForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("mode", "new");
		return "student/form";
	}

	// Use-case 4: Show the edit form pre-filled with a student's data.
	@GetMapping("/student/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Student student = studentService.getStudentById(id);
		if (student == null) {
			return "redirect:/eregistrar/student/list";
		}
		model.addAttribute("student", student);
		model.addAttribute("mode", "edit");
		return "student/form";
	}

	// Handles both create (use-case 3) and update (use-case 4) submissions.
	@PostMapping("/student/save")
	public String saveStudent(@Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("mode",
					student.getStudentId() == null ? "new" : "edit");
			return "student/form";
		}
		studentService.saveStudent(student);
		return "redirect:/eregistrar/student/list";
	}

	// Use-case 5: Delete a student.
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/eregistrar/student/list";
	}

	// Extra credit: search for students.
	@GetMapping("/student/search")
	public String searchStudents(@RequestParam(value = "keyword", required = false) String keyword,
			Model model) {
		model.addAttribute("students", studentService.searchStudents(keyword));
		model.addAttribute("keyword", keyword);
		return "student/list";
	}
}
