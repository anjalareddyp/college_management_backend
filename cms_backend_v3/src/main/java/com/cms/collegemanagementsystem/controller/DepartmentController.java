package com.cms.collegemanagementsystem.controller;

import com.cms.collegemanagementsystem.modal.Department;
import com.cms.collegemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department/all")
    public ResponseEntity findAllDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity(departments, HttpStatus.OK);
    }

    @PostMapping("/department/save")
    public ResponseEntity saveDepartment(@RequestBody Department department){
        department = departmentService.save(department);
        return new ResponseEntity(department, HttpStatus.OK);
    }

    @GetMapping("/department/delete/{departmentId}")
    public ResponseEntity deleteDepartment(@PathVariable("departmentId") int departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity("Department Deleted", HttpStatus.OK);
    }

    @PostMapping("/department/update")
    public ResponseEntity updateDepartment(@RequestBody Department department){
        department = departmentService.updateDepartment(department);
        return new ResponseEntity(department, HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity getDepartment(@PathVariable("departmentId") int departmentId){
        Department department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity(department, HttpStatus.OK);
    }

}
