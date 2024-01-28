package com.unitTest.unitTest.services;

import com.unitTest.unitTest.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class StudentServiceTest {
    @MockBean
    StudentRepository studentRepository;
    StudentService studentService;
    @Test
    public void testGetAllStudents(){

    }
}
