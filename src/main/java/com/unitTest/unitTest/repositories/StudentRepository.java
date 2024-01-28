package com.unitTest.unitTest.repositories;

import com.unitTest.unitTest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
}
