package com.example.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.courses.interfaces.CourseRepository;
import com.example.courses.models.Course;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getCourseById(Long id) {
		return courseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Couse not found"));
	}
	
	@Transactional
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}
	
	@Transactional
	public Course updateCourse(Long id, Course courseDetails) {
		Course course = getCourseById(id);
		course.setTitle(courseDetails.getTitle());
		return courseRepository.save(course);
	}
	
	@Transactional
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
}
