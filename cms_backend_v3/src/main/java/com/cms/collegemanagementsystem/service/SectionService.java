package com.cms.collegemanagementsystem.service;

import com.cms.collegemanagementsystem.dto.SectionDTO;
import com.cms.collegemanagementsystem.dto.StudentDTO;
import com.cms.collegemanagementsystem.modal.*;
import com.cms.collegemanagementsystem.repo.ProfessorRepo;
import com.cms.collegemanagementsystem.repo.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepo sectionRepo;

    @Autowired
    private NextSequenceService nextSequenceService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private DepartmentService departmentService;

    public List<Section> findAllSections(){
        return sectionRepo.findAll();
    }

    @Autowired
    private ProfessorRepo professorRepo;

    public Section saveSection(Section section){
        section.setId(nextSequenceService.getNextSequence(Section.sequence));
        section.setAvailableSeats(section.getCapacity());
        sectionRepo.save(section);
        return section;
    }

    public Section registerStudentInSection(StudentDTO studentDTO, int sectionId){
        Section section = findSectionById(sectionId);
        List<StudentDTO> studentDTOList = section.getStudents() == null ? new ArrayList<>() : section.getStudents();
        studentDTOList.add(studentDTO);
        section.setAvailableSeats(section.getAvailableSeats() - 1);
        sectionRepo.save(section);
        return section;
    }
    public Section deregisterStudentInSection(StudentDTO studentDTO, int sectionId) {
        Section section = findSectionById(sectionId);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentDTO studentDTO1 : section.getStudents()){
            if(studentDTO1.getStudentId() != studentDTO.getStudentId()){
                studentDTOList.add(studentDTO1);
            }
        }
        section.setStudents(studentDTOList);
        section.setAvailableSeats(section.getAvailableSeats() + 1);
        section = sectionRepo.save(section);
        return section;
    }

    public Section findSectionById(int sectionId){
        Section section = sectionRepo.findById(sectionId).get();
        return section;
    }

    public Section update(Section section) {
        return sectionRepo.save(section);
    }

    public List<SectionDTO> getAllSections(){
        List<Section> sections = findAllSections();
        List<SectionDTO> sectionDTOList = new ArrayList<>();
        for(Section section : sections){
            SectionDTO sectionDTO = getSectionDTOWithSection(section);
            sectionDTOList.add(sectionDTO);
        }
        return sectionDTOList;
    }

    private SectionDTO getSectionDTOWithSection(Section section) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(section.getId());
        Professor professor = professorService.getProfessorById(section.getProfessorId());
        sectionDTO.setProfessorName(professor.getFirstName());
        Course course = courseService.getCourseById(section.getCourseId());
        sectionDTO.setCourseDescription(course.getCourseDescription());
        Room room = roomService.getRoomById(section.getRoomId());
        sectionDTO.setCapacity(room.getCapacity());
        sectionDTO.setRoomNo(room.getRoomNo());
       // sectionDTO.setCapacity(section.getCapacity());
        sectionDTO.setAvailableSeats(section.getAvailableSeats());
        Department department = departmentService.getDepartmentById(section.getDepartmentId());
        sectionDTO.setDepartmentName(department.getDepartment());
        sectionDTO.setSectionName(section.getSectionName());
        sectionDTO.setCourseId(course.getCourseId());
        sectionDTO.setStudents(section.getStudents());

        return sectionDTO;
    }


    public List<SectionDTO> getAllSectionsByDepartmentIdAndCourseId(int departmentId, int courseId, int studentId){
        List<Section> sections = sectionRepo.findAllByDepartmentIdAndCourseId(departmentId, courseId);
        List<SectionDTO> sectionDTOList = new ArrayList<>();
        for(Section section : sections){
            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setId(section.getId());
            Professor professor = professorService.getProfessorById(section.getProfessorId());
            sectionDTO.setProfessorName(professor.getFirstName());
            Course course = courseService.getCourseById(section.getCourseId());
            sectionDTO.setCourseDescription(course.getCourseDescription());
            Room room = roomService.getRoomById(section.getRoomId());
            sectionDTO.setRoomNo(room.getRoomNo());
            sectionDTO.setAvailableSeats(section.getAvailableSeats());
            //sectionDTO.setCapacity(section.getCapacity());
            sectionDTO.setCapacity(room.getCapacity());
            Department department = departmentService.getDepartmentById(section.getDepartmentId());
            sectionDTO.setDepartmentName(department.getDepartment());
            sectionDTO.setSectionName(section.getSectionName());
            sectionDTO.setCourseId(course.getCourseId());
            System.out.println(section.toString());
            if(checkIfStudentPresentInSection(section, studentId)) {
                sectionDTO.setRegistered(1);
            }
            else{
                sectionDTO.setRegistered(0);
            }
            sectionDTOList.add(sectionDTO);
        }

        return sectionDTOList;
    }


    public List<SectionDTO> getAllCoursesOfStudent(int studentId){
        List<Section> sections = sectionRepo.findAll();
        List<SectionDTO> result = new ArrayList<>();
        for(Section section : sections){
            if(checkIfStudentPresentInSection(section, studentId)) {
                result.add(getSectionDTOWithSection(section));
            }
        }
        return result;
    }
    private boolean checkIfStudentPresentInSection(Section section, int studentId){
        for(StudentDTO studentDTO : section.getStudents()){
            if(studentDTO.getStudentId() == studentId){
                return true;
            }
        }
        return false;
    }

}
