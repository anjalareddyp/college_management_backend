package com.cms.collegemanagementsystem.controller;

import com.cms.collegemanagementsystem.dto.SectionDTO;
import com.cms.collegemanagementsystem.dto.StudentDTO;
import com.cms.collegemanagementsystem.modal.Section;
import com.cms.collegemanagementsystem.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SectionController {

    @Autowired
    private SectionService sectionService;


    @GetMapping("/section/all")
    public ResponseEntity allSections(){
        List<SectionDTO> sections = sectionService.getAllSections();
        return new ResponseEntity(sections, HttpStatus.OK);
    }

    @PostMapping("/section/add")
    public ResponseEntity addSection(@RequestBody Section section){
        section = sectionService.saveSection(section);
        return new ResponseEntity(section, HttpStatus.OK);
    }

    @PostMapping("/section/update")
    public ResponseEntity updateSection(@RequestBody Section section){
        section = sectionService.update(section);
        return new ResponseEntity(section, HttpStatus.OK);
    }

    @PostMapping("/section/register/student/{sectionId}")
    public ResponseEntity registerStudent(@RequestBody StudentDTO studentDTO, @PathVariable("sectionId") int sectionId){
        Section section = sectionService.registerStudentInSection(studentDTO, sectionId);
        return new ResponseEntity(section, HttpStatus.OK);
    }

    @PostMapping("/section/deregister/student/{sectionId}")
    public ResponseEntity deregisterStudent(@RequestBody StudentDTO studentDTO, @PathVariable("sectionId") int sectionId){
        Section section = sectionService.deregisterStudentInSection(studentDTO, sectionId);
        return new ResponseEntity(section, HttpStatus.OK);
    }


    @GetMapping("/section/all/{departmentId}/{courseId}/{studentId}")
    public ResponseEntity getAllSectionsByDepartmentIdAndCourseId(@PathVariable("departmentId") int departmentId, @PathVariable("courseId") int courseId, @PathVariable("studentId") int studentId){
        List<SectionDTO> sectionDTOList = sectionService.getAllSectionsByDepartmentIdAndCourseId(departmentId, courseId, studentId);
        return new ResponseEntity(sectionDTOList, HttpStatus.OK);
    }

    @GetMapping("/section/student/all/{studentId}")
    public ResponseEntity getAllSectionsOfStudent(@PathVariable("studentId") int studentId){
        List<SectionDTO> sections = sectionService.getAllCoursesOfStudent(studentId);
        return new ResponseEntity(sections, HttpStatus.OK);
    }

    @GetMapping("/section/{sectionId}")
    public ResponseEntity getSectionById(@PathVariable("sectionId") int sectionId){
        Section section = sectionService.findSectionById(sectionId);
        return new ResponseEntity(section, HttpStatus.OK);
    }

}
