package com.cms.collegemanagementsystem.modal;

import com.cms.collegemanagementsystem.dto.StudentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("section")
@Data
@NoArgsConstructor
@ToString
public class Section {

    public static String sequence = "SECTION_SEQUENCE";

    @Id
    private int id;

    private int courseId;

    private int roomId;

    private int departmentId;

    private int capacity;

    private int availableSeats;

    private List<StudentDTO> students = new ArrayList<>();

    private int professorId;

    private String sectionName;

}
