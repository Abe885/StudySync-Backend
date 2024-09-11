package com.coderscampus.studysync.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String communityName;
    private String description;
    private String category;
    private Boolean isFlagged;
    private Boolean isPrivate;
    @ManyToMany
    @JoinTable(
            name = "study_group_user",
            joinColumns = @JoinColumn(name = "study_group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new ArrayList<>();
}
