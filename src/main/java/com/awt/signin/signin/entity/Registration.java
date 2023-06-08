package com.awt.signin.signin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String email;
    private String phoneNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String preferredCourses;

    private String message;



    public Registration() {
    }

    public Registration(String message) {
        this.message = message;
    }
}
