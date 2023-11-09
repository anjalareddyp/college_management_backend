package com.cms.collegemanagementsystem.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    public static String sequence = "DEPARTMENT_SEQUENCE";
    @Id
    private int id;
    private String department;

}
