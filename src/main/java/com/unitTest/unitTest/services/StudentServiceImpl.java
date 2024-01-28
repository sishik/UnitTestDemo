package com.unitTest.unitTest.services;

import com.unitTest.unitTest.exception.StudentNotFoundException;
import com.unitTest.unitTest.model.Student;
import com.unitTest.unitTest.repositories.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.UUID;
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student>students=studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    @Override
    public ResponseEntity<Student> getStudentById(Long id) throws StudentNotFoundException {
        Optional<Student>student=studentRepository.findById(id);
        if (student.isPresent()){
            return ResponseEntity.ok(student.get());
        }
        else {
            throw new StudentNotFoundException("Student not found with id "+id);
        }
    }

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        Student student1=studentRepository.save(student);
        return ResponseEntity.ok(student1);
    }
}
