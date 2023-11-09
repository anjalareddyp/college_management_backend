package com.cms.collegemanagementsystem.repo;

import com.cms.collegemanagementsystem.modal.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepo extends MongoRepository<Professor, Integer> {
    Optional<Professor> findByEmailAndPassword(String email, String password);

}
