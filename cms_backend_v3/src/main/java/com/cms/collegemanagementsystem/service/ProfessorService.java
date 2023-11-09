package com.cms.collegemanagementsystem.service;

import com.cms.collegemanagementsystem.modal.Professor;
import com.cms.collegemanagementsystem.repo.ProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepo professorRepo;

    @Autowired
    private NextSequenceService nextSequenceService;

    public Professor saveProfessor(Professor professor){
        professor.setId(nextSequenceService.getNextSequence(Professor.sequence));
        professor = professorRepo.save(professor);
        return professor;
    }

    public Professor getProfessorById(int professorId){
        Professor professor = professorRepo.findById(professorId).get();
        return professor;
    }

    public Professor update(Professor professor){
        professor = professorRepo.save(professor);
        return professor;
    }

    public void delete(int professorId){
        Professor professor = getProfessorById(professorId);
        professorRepo.delete(professor);
    }

    public Professor authenticate(String email, String password) {
        return professorRepo.findByEmailAndPassword(email, password).get();
    }
}
