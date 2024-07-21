package com.coderscampus.studysync.service;

import com.coderscampus.studysync.domain.User;
import com.coderscampus.studysync.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void saveUser(User user) {
        userRepository.save(user);
    }
}
