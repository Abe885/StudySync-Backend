package com.coderscampus.studysync.repository;

import com.coderscampus.studysync.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
