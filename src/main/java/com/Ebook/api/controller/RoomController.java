package com.Ebook.api.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ebook.api.exception.ResourceNotFoundException;
import com.Ebook.api.model.Room;
import com.Ebook.api.repository.RoomRepository;



@RestController
@RequestMapping("/api/v1")

public class RoomController {
    
    @Autowired
    private  RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable("id") Long roomid) {
        Room room = roomRepository.findById(roomid).orElseThrow(() -> new ResourceNotFoundException("Room  not found for this id :: " + roomid));
      
        return ResponseEntity.ok(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable("id") Long roomId, @RequestBody Room roomDetails) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room  not found for this id :: " + roomId));
        room.setRoomNumber(roomDetails.getRoomNumber());
        room.setRoom_class(roomDetails.getRoom_class());
        room.setStatus(roomDetails.getStatus());
        room.setStatus(roomDetails.getDescription());
      
        final Room updatedRoom = roomRepository.save(room);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room  not found for this id :: " + roomId));
       roomRepository.delete(room);
        return ResponseEntity.ok().build();
   
    }



}




