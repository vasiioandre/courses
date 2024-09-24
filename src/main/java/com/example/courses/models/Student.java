package com.example.courses.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@ManyToMany
	@JoinTable(
		name = "student_course",
		joinColumns = @JoinColumn(name="student_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private Set<Course> courses = new HashSet<>();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	} 
	
	public void addCourse(Course course) {
		this.courses.add(course);
		course.getStudents().add(this);
	}
	
	public void deleteCourse(Course course) {
		this.courses.remove(course);
		course.getStudents().remove(this);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", courses=" + courses + "]";
	}
}
