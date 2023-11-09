package com.cms.collegemanagementsystem.controller;

import com.cms.collegemanagementsystem.modal.Room;
import com.cms.collegemanagementsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("room/all")
    public ResponseEntity allRooms(){
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    @PostMapping("/room/add")
    public ResponseEntity addRoom(@RequestBody Room room){
         room = roomService.addRoom(room);
         return new ResponseEntity(room, HttpStatus.OK);
    }
}
