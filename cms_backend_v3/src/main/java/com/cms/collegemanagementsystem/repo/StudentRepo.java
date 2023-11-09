package com.cms.collegemanagementsystem.repo;

import com.cms.collegemanagementsystem.modal.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student, Integer> {

    public Student findByEmailAndPassword(String email, String password);
}
