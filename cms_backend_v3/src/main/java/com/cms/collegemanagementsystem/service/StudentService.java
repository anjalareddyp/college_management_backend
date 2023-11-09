package com.cms.collegemanagementsystem.service;

import com.cms.collegemanagementsystem.modal.Student;
import com.cms.collegemanagementsystem.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private NextSequenceService nextSequenceService;

    public Student authenticateUser(String email, String password){
        Student student = studentRepo.findByEmailAndPassword(email, password);
        return student;
    }

    public Student registerStudent(Student student){
        student.setId(nextSequenceService.getNextSequence(Student.sequence));
        return studentRepo.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
}
