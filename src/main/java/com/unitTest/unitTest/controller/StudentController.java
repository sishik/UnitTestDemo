package com.unitTest.unitTest.controller;

import com.unitTest.unitTest.exception.StudentNotFoundException;
import com.unitTest.unitTest.model.Student;
import com.unitTest.unitTest.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id)throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }
}
