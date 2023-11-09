package com.cms.collegemanagementsystem.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Professor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {

    public final static String sequence = "PROFESSOR_SEQUENCE";
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int departmentId;
    private String password;
    private String email;

}