package com.example.CRUD_STUDENT.controller;

import com.example.CRUD_STUDENT.model.Student;
import com.example.CRUD_STUDENT.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        try{
            List<Student> studentList = new ArrayList<>();
            studentRepository.findAll().forEach(studentList::add);
            if(studentList.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        try
        {
            Student studentObj = studentRepository.save(student);
            return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id , @RequestBody Student student)
    {
        try
        {
            Optional<Student> studentData = studentRepository.findById(id);
            if(studentData.isPresent())
            {
                Student updateStudent = studentData.get();
                updateStudent.setName(student.getName());
                updateStudent.setDob(student.getDob());
                updateStudent.setClassname(student.getClassname());
                updateStudent.setJoiningdate(student.getJoiningdate());
                Student studentObj = studentRepository.save(updateStudent);
                return new ResponseEntity<>(studentObj,HttpStatus.CREATED);

            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
