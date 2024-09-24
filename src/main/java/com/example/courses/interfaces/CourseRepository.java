package com.example.courses.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courses.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
