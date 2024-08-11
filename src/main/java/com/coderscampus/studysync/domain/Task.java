package com.coderscampus.studysync.domain;

import jakarta.persistence.*;

import lombok.Data;



@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean isComplete;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "study_quest_id")
    private StudyQuest studyQuest;

}
