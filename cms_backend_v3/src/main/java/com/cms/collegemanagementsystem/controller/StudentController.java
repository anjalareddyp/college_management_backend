package com.cms.collegemanagementsystem.controller;

import com.cms.collegemanagementsystem.modal.Student;
import com.cms.collegemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/student/login")
    public ResponseEntity login(@RequestBody Student student){
        Student student1 = studentService.authenticateUser(student.getEmail(), student.getPassword());
        if(student1 != null){
            return new ResponseEntity(student1, HttpStatus.OK);
        }
       return new ResponseEntity("User Not found", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/student/register")
    public ResponseEntity register(@RequestBody Student student){
        Student student1 = studentService.registerStudent(student);
        return new ResponseEntity(student1, HttpStatus.OK);
    }

    @GetMapping("/student/all")
    public ResponseEntity getAllStudents(){
        List<Student> students = studentService.getAllStudent();
        return new ResponseEntity(students, HttpStatus.OK);
    }

}
