package com.cms.collegemanagementsystem.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    public static String sequence = "ROOM_SEQUENCE";

    @Id
    private int id;

    private int roomNo;

    private int capacity;
}
