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
import com.Ebook.api.model.User_role;
import com.Ebook.api.repository.UserRoleRepository;

@RestController
@RequestMapping("/api/v1")
public class UserRoleController {
    @Autowired
    UserRoleRepository userRoleRepository;

    @GetMapping("/userRole")
    public List<User_role> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @GetMapping("/userRole/{id}")
    public ResponseEntity<User_role> getUserRoleById(@PathVariable(value = "id") Long userRoleId)
            throws ResourceNotFoundException {
        Optional<User_role> userRole = userRoleRepository.findById(userRoleId);
        if (userRole.isPresent()) {
            return ResponseEntity.ok().body(userRole.get());
        } else {
            throw new ResourceNotFoundException("ID not found: " + userRoleId);
        }
    }

    @PostMapping("/userRole")
    public User_role createUserRole(@Valid @RequestBody User_role userRole) {
        return userRoleRepository.save(userRole);
    }


    @PutMapping("/userRole/{id}")
    public User_role updateUserRole(@PathVariable(value = "id") Long userRoleId,
            @Valid @RequestBody User_role userRoleDetails) throws ResourceNotFoundException {
            
        Optional<User_role> userRole = userRoleRepository.findById(userRoleId);
        if (userRole.isPresent()) {
            userRole.get().setId(userRoleId);
            userRole.get().setRole(userRoleDetails.getRole());
            return userRoleRepository.save(userRole.get());
        } else {
            throw new ResourceNotFoundException("ID not found: " + userRoleId);
        }
    }

    @DeleteMapping("/userRole/{id}")
    public ResponseEntity<?> deleteUserRole(@PathVariable(value = "id") Long userRoleId)
            throws ResourceNotFoundException {
        Optional<User_role> userRole = userRoleRepository.findById(userRoleId);
        if (userRole.isPresent()) {
            userRoleRepository.deleteById(userRoleId);
            return ResponseEntity.ok().body(userRole.get());
        } else {
            throw new ResourceNotFoundException("ID not found: " + userRoleId);
        }
    }


}
