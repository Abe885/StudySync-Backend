package com.coderscampus.studysync.repository;

import com.coderscampus.studysync.domain.StudyQuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyQuestRepository extends JpaRepository<StudyQuest, Long> {

}
