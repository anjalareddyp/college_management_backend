package com.cms.collegemanagementsystem.dto;

import com.cms.collegemanagementsystem.modal.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SectionDTO {

    private int id;

    private String courseDescription;

    private String courseId;

    private String professorName;

    private String departmentName;

    private int roomNo;

    private int availableSeats;
    private int capacity;
    private int registered;

    private List<StudentDTO> students;

    private String sectionName;

    public SectionDTO(Section section) {
    }
}
