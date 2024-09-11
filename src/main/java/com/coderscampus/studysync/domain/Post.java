package com.coderscampus.studysync.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private StudyGroup studyGroup;
    @OneToMany
    private List<Comment> comments = new ArrayList<>();
}
