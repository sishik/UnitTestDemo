package com.unitTest.unitTest.controller;

import com.unitTest.unitTest.model.Student;
import com.unitTest.unitTest.services.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class StudentControllerTest {
    @MockBean
    StudentService studentService;
    StudentController studentController;

    public StudentControllerTest(StudentController studentController) {
        this.studentController = studentController;
    }

    @Test
    public void testAddStudent() {
        // Create a student instance
        Student student = new Student(10L, "Rahul", 90, "shiva@yahoomail");

        // Mock the behavior of the service method
        Mockito.when(studentService.createStudent(Mockito.any(Student.class))).thenReturn(ResponseEntity.ok(student));

        // Call the service method
        ResponseEntity<Student> responseEntity = studentService.createStudent(student);

        // Get the saved student from the response
        Student savedStudent = responseEntity.getBody();

        // Assertions
        Assertions.assertNotNull(savedStudent);
        Assertions.assertEquals(student.getId(), savedStudent.getId());
        Assertions.assertEquals(student.getName(), savedStudent.getName());
        Assertions.assertEquals(student.getMarks(), savedStudent.getMarks());
        Assertions.assertEquals(student.getEmail(), savedStudent.getEmail());
    }
}
