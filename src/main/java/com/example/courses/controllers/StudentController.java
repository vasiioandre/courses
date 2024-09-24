package com.example.courses.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.models.Student;
import com.example.courses.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
	
	@PostMapping("/{studentId}/courses/{courseId}")
	public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
		studentService.addCourseToStudent(studentId, courseId);
	}

}
