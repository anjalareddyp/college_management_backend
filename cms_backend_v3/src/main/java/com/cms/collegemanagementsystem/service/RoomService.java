package com.cms.collegemanagementsystem.service;

import com.cms.collegemanagementsystem.modal.Room;
import com.cms.collegemanagementsystem.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private NextSequenceService nextSequenceService;

    public List<Room> getAllRooms(){
        return roomRepo.findAll();
    }

    public Room addRoom(Room room){
        room.setId(nextSequenceService.getNextSequence(Room.sequence));
        return roomRepo.save(room);
    }

    public Room getRoomById(int roomId){
        return roomRepo.findById(roomId).get();
    }
}
