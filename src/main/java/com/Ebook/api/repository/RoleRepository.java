package com.Ebook.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.Ebook.api.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // @Query("SELECT l FROM Logs l WHERE l.email=?1")
    // List<Logs> findLogsByEmail(String emailAddress);
}