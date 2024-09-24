package com.example.courses.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courses.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
