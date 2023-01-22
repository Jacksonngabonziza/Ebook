package com.Ebook.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Hidden
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends AuditModel {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

   @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName", unique = true, nullable = false)
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "status", nullable = false)
    private String status;


}
