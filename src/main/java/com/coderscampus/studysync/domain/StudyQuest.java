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
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;
    @OneToMany(mappedBy = "studyQuest", cascade = CascadeType.ALL)
    private List<Task> tasks;

   public int getTotalTasks() {
        return tasks != null ? tasks.size() : 0;
    }

    public long getCompletedTasks() {
        return tasks != null ? tasks.stream().filter(Task::getIsComplete).count() : 0;
    }

    public double getProgress() {
        int totalTasks = getTotalTasks();
        return totalTasks > 0 ? (double) getCompletedTasks() / totalTasks : 0.0;
    }
}
