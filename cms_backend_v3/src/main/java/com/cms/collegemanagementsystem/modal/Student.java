package com.cms.collegemanagementsystem.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    public static String sequence = "STUDENT_SEQUENCE";
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int departmentId;
    private String email;
    private String password;
}
