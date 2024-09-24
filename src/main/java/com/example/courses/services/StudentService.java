package com.example.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.courses.interfaces.CourseRepository;
import com.example.courses.interfaces.StudentRepository;
import com.example.courses.models.Course;
import com.example.courses.models.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	StudentRepository studentRepository;
	CourseRepository courseRepository;
	
	public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Student not found"));
	}

	@Transactional
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Transactional
	public Student updateStudent(Long id, Student studentDetails) {
		Student student = getStudentById(id);
		student.setName(studentDetails.getName());
		
		return studentRepository.save(student);
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Transactional
	public void addCourseToStudent(Long studentId, Long courseId) {
		Student student = getStudentById(studentId);
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new IllegalArgumentException("Course not found"));
		student.addCourse(course);
		studentRepository.save(student);
	}
	


}
