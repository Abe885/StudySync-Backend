package com.coderscampus.studysync.domain;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Entity
@Data
public class StudyQuest {
    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isComplete;
    private int totalTasks;
    private int completedTasks;

    @ManyToOne
    private User user;

    @ManyToOne
    private StudyGroup studyGroup;

    @OneToMany
    private List<Task> tasks;

    public double getProgress() {
        return (double) completedTasks / totalTasks;
    }

}
