package com.coderscampus.studysync.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import lombok.Data;



@Entity
@Data
public class Task {

    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isComplete;

    @ManyToOne
    private StudyQuest studyQuest;

}
