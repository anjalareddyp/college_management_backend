package com.cms.collegemanagementsystem.service;

import com.cms.collegemanagementsystem.modal.Department;
import com.cms.collegemanagementsystem.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private NextSequenceService nextSequenceService;

    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    public Department save(Department department){
        department.setId(nextSequenceService.getNextSequence(Department.sequence));
        return departmentRepo.save(department);
    }

    public Department getDepartmentById(int departmentId){
        Department department = departmentRepo.findById(departmentId).get();
        return department;
    }

    public Department updateDepartment(Department department){
        department = departmentRepo.save(department);
        return department;
    }

    public void deleteDepartment(int departmentId){
        Department department = getDepartmentById(departmentId);
        departmentRepo.delete(department);
    }

}
