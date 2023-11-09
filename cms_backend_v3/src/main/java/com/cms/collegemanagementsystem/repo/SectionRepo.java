package com.cms.collegemanagementsystem.repo;

import com.cms.collegemanagementsystem.modal.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepo extends MongoRepository<Section, Integer> {
    List<Section> findAllByDepartmentIdAndCourseId(int departmentId, int courseId);
}
