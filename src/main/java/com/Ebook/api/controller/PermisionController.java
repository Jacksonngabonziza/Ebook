package com.Ebook.api.controller;
import java.util.List;

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
import com.Ebook.api.model.Permisions;
import com.Ebook.api.repository.PermisionsRepository;


@RestController
@RequestMapping("/api/v1")
public class PermisionController {
    
    @Autowired
    private PermisionsRepository permisionsRepository;

    @GetMapping("/permisions")
    public List<Permisions> getAllPermisions(){
        return permisionsRepository.findAll();
    }

    @GetMapping("/permisions/{id}")
    public ResponseEntity<Permisions> getPermisionsById(@PathVariable(value = "id") Long permisionId) {
        return permisionsRepository.findById(permisionId)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/permisions")
    public Permisions createPermision(@Valid @RequestBody Permisions permisions) {
        return permisionsRepository.save(permisions);
    }

    @PutMapping("/permisions/{id}")
    public ResponseEntity<Permisions> updatePermision(@PathVariable(value = "id") Long permisionId,@Valid @RequestBody Permisions permisionDetails) {
		
				
        Permisions permisions = permisionsRepository.findById(permisionId)
        .orElseThrow(() -> new IllegalArgumentException("Permision not found"));
					
					permisions.setName(permisionDetails.getName());
                    permisions.setDescription(permisionDetails.getDescription());
                    permisions.setDisplay_name(permisionDetails.getDisplay_name());
                    return ResponseEntity.ok(permisionsRepository.save(permisions));								 
         }


    @DeleteMapping("/permisions/{id}")
    public ResponseEntity<Permisions> deletePermision(@PathVariable(value = "id") Long permisionId) {
		
				
        Permisions permisions = permisionsRepository.findById(permisionId)
        .orElseThrow(() -> new IllegalArgumentException("Permision not found"));
						
					permisionsRepository.delete(permisions);
                    return ResponseEntity.ok(permisions);								 
         }

}

 

