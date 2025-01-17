package com.studysync.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    private Post post;
    private Boolean isFlagged;

}
