package com.unitTest.unitTest.services;

import com.unitTest.unitTest.exception.StudentNotFoundException;
import com.unitTest.unitTest.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface StudentService {
    ResponseEntity<List<Student>> getAllStudents();
    ResponseEntity<Student> getStudentById(Long id) throws StudentNotFoundException;
    ResponseEntity<Student> createStudent(Student student);

}
