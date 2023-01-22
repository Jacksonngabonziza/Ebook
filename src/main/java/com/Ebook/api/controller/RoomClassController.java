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
import com.Ebook.api.model.Room_class;
import com.Ebook.api.repository.RoomClassRepository;



@RestController
@RequestMapping("/api/v1")
public class RoomClassController {
    @Autowired
    private RoomClassRepository roomClassRepository;


	@GetMapping("/roomclasses")
    public List<Room_class> getAllRoomClasses(){
    	return roomClassRepository.findAll();
    }
	
	@GetMapping("/roomclasses/{id}")
    public ResponseEntity<Room_class> getRoomClassById(@PathVariable(value = "id") Long roomClassId) {
		Room_class roomClass = roomClassRepository.findById(roomClassId).orElseThrow(() -> new ResourceNotFoundException("Room class not found for this id :: " + roomClassId));
		return ResponseEntity.ok().body(roomClass);
    }
	
	@PostMapping("/roomclasses")
    public ResponseEntity<Room_class> createRoomClass(@Valid @RequestBody Room_class roomClass) {
		return ResponseEntity.ok().body(roomClassRepository.save(roomClass));
    }
	
	@PutMapping("/roomclasses/{id}")
    public ResponseEntity<Room_class> updateRoomClass(@PathVariable(value = "id") Long roomClassId,
			@Valid @RequestBody Room_class roomClassDetails) {
	Room_class roomClass = roomClassRepository.findById(roomClassId).get();


		roomClass.setName(roomClassDetails.getName());
		roomClass.setImage(roomClassDetails.getImage());
        roomClass.setDescription(roomClassDetails.getDescription());
        roomClass.setStatus(roomClassDetails.getStatus());
        roomClass.setPrice(roomClassDetails.getPrice());
    	return ResponseEntity.ok().body(roomClassRepository.save(roomClass));
    }
	
	@DeleteMapping("/roomclasses/{id}")
    public ResponseEntity<?> deleteRoomClass(@PathVariable(value = "id") Long roomClassId) {
    	roomClassRepository.deleteById(roomClassId);
    	return ResponseEntity.ok().build();
    }
	
	
	

}

