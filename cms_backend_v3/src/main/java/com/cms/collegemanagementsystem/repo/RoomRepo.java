package com.cms.collegemanagementsystem.repo;

import com.cms.collegemanagementsystem.modal.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends MongoRepository<Room, Integer> {
}
