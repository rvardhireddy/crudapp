package com.example.CRUD_STUDENT.repository;

import com.example.CRUD_STUDENT.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
