package com.cms.collegemanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDTO {
    private int studentId;
    private String name;
    private double grade;
    private String status = "REGISTERED";
}
