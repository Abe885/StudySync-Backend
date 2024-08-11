package com.coderscampus.studysync.service;

import com.coderscampus.studysync.domain.StudyQuest;
import com.coderscampus.studysync.domain.Task;
import com.coderscampus.studysync.domain.User;
import com.coderscampus.studysync.repository.StudyQuestRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaderboardService {
    private final StudyQuestRepository studyQuestRepository;

    public LeaderboardService(StudyQuestRepository studyQuestRepository) {
        this.studyQuestRepository = studyQuestRepository;
    }

    public List<User> getTopUsersByQuestProgress(Long questId) {
        return studyQuestRepository.findById(questId)
                .map(quest -> quest.getStudyGroup()
                        .getUsers()
                        .stream()
                        .sorted(Comparator.comparing(user -> getUserQuestProgress((User) user, quest)).reversed())
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    private double getUserQuestProgress(User user, StudyQuest quest) {
        List<Task> userTasksForQuest = user.getTasksForQuest(quest);
        long completedTasks = userTasksForQuest.stream().filter(Task::getIsComplete).count();
        return quest.getTotalTasks() > 0 ? (double) completedTasks / quest.getTotalTasks() : 0;
    }
}

