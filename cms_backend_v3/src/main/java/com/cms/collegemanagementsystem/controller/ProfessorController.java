package com.cms.collegemanagementsystem.controller;

import com.cms.collegemanagementsystem.modal.Professor;
import com.cms.collegemanagementsystem.repo.ProfessorRepo;
import com.cms.collegemanagementsystem.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ProfessorRepo professorRepo;

    @PostMapping("/professor/add")
    public ResponseEntity addProfessor(@RequestBody Professor professor){
        professor = professorService.saveProfessor(professor);
        return new ResponseEntity(professor, HttpStatus.OK);
    }

    @PostMapping("/professor/update")
    public ResponseEntity updateProfessor(@RequestBody Professor professor){
        professor = professorService.update(professor);
        return new ResponseEntity(professor, HttpStatus.OK);
    }


    @PostMapping("/professor/login")
    public ResponseEntity login(@RequestBody Professor professor){
        professor = professorService.authenticate(professor.getEmail(), professor.getPassword());
        return new ResponseEntity(professor, HttpStatus.OK);
    }

    @GetMapping("/professor/delete/{professorId}")
    public ResponseEntity deleteProfessor(@PathVariable("professorId") int professorId){
        professorService.delete(professorId);
        return new ResponseEntity("Professor Deleted", HttpStatus.OK);
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity getProfessor(@PathVariable("professorId") int professorId){
        Professor professor = professorService.getProfessorById(professorId);
        return new ResponseEntity(professor, HttpStatus.OK);
    }

    @GetMapping("/professor/all")
    public ResponseEntity allProfessors(){
        return new ResponseEntity(professorRepo.findAll(), HttpStatus.OK);
    }

}
