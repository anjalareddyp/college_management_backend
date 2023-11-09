package com.cms.collegemanagementsystem.modal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    public static String sequence = "COURSE_SEQUENCE";
    @Id
    private int id;
    private String courseId;
    private String courseDescription;
    private int creditHours;
    private int departmentId;
}
