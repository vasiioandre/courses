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

import com.example.courses.models.Course;
import com.example.courses.services.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}
	
	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}
	
	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
		return courseService.updateCourse(id, course);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}
}
