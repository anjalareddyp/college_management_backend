package com.cms.collegemanagementsystem.controller;

import com.cms.collegemanagementsystem.modal.Course;
import com.cms.collegemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses/all")
    public ResponseEntity courses(){
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity(courses, HttpStatus.OK);
    }

    @PostMapping("/course/add")
    public ResponseEntity addCourse(@RequestBody Course course){
        course = courseService.save(course);
        return new ResponseEntity(course, HttpStatus.OK);
    }

    @PostMapping("/course/delete/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable("courseId") int courseId){
        Course course = courseService.getCourseById(courseId);
        courseService.delete(course);
        return new ResponseEntity("Course Deleted", HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity getCourseById(@PathVariable("courseId") int courseId){
        Course course = courseService.getCourseById(courseId);
        return new ResponseEntity(course, HttpStatus.OK);
    }

    @PostMapping("/course/update")
    public ResponseEntity updateCourse(@RequestBody Course course){
        courseService.update(course);
        return new ResponseEntity("Course Details Updated", HttpStatus.OK);
    }

    @GetMapping("/course/department/{departmentId}")
    public ResponseEntity getAllCoursesByDepartment(@PathVariable("departmentId") int departmentId){
        List<Course> courses = courseService.findAllCoursesByDepartmentId(departmentId);
        return new ResponseEntity(courses, HttpStatus.OK);
    }

}
