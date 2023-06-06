package com.awt.signin.signin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Table(name = "registration", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
public class Registration {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    //@Column(unique = true)
    private String email;
    private String phoneNumber;
    private String password;
    private String preferredCourses;



}
