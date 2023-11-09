package com.cms.collegemanagementsystem.repo;

import com.cms.collegemanagementsystem.modal.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, Integer> {


}
