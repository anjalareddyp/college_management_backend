package com.cms.collegemanagementsystem.service;

import com.cms.collegemanagementsystem.modal.Course;
import com.cms.collegemanagementsystem.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private NextSequenceService nextSequenceService;

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }

    public Course save(Course course) {
        course.setId(nextSequenceService.getNextSequence(Course.sequence));
        return courseRepo.save(course);
    }

    public Course getCourseById(int courseId){
        return courseRepo.findById(courseId).get();
    }

    public void delete(Course course) {
        courseRepo.delete(course);
    }

    public void update(Course course) {
        courseRepo.save(course);
    }

    public List<Course> findAllCoursesByDepartmentId(int departmentId){
        return courseRepo.findAllByDepartmentId(departmentId);
    }
}
