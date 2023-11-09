package com.cms.collegemanagementsystem.repo;

import com.cms.collegemanagementsystem.modal.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends MongoRepository<Course, Integer> {
    List<Course> findAllByDepartmentId(int departmentId);
}
