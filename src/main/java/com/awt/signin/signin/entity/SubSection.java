package com.awt.signin.signin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class SubSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subsection_id;

    private String subsectionName;

    private String referenceLink;

    @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "section_id")
     private Section section;

     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "course_id")
     private Courses courses;



}

