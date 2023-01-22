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
import com.Ebook.api.model.Role;
import com.Ebook.api.repository.RoleRepository;


@RestController
@RequestMapping("/api/v1")
public class RoleController {



    @Autowired
    private RoleRepository roleRepository;
    
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(name="id") Long roleId) {
        Role role = roleRepository.findById(roleId).orElse(null);
        if(role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }
    
    @PostMapping("/roles")
    public Role createRole(@Valid @RequestBody Role role) {
        return roleRepository.save(role);
    }
    
    @PutMapping("/roles/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable(name="id") Long roleId,
                                          @Valid @RequestBody Role roleDetails) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Role not found"));
        role.setDisplay_name(roleDetails.getDisplay_name());
        role.setName(roleDetails.getName());
        return ResponseEntity.ok(roleRepository.save(role));
}


@DeleteMapping("/role/{id}")
public ResponseEntity<Role> deleteRole(@PathVariable(value = "id") Long RoleId) {  
    Role role = roleRepository.findById(RoleId).orElseThrow(() -> new IllegalArgumentException("Role not found"));

        roleRepository.delete(role);
    return ResponseEntity.ok().build();							 
     }


}
