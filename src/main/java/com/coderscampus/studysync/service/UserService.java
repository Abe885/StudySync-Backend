package com.coderscampus.studysync.service;

import com.coderscampus.studysync.domain.Role;
import com.coderscampus.studysync.domain.User;
import com.coderscampus.studysync.repository.RoleRepository;
import com.coderscampus.studysync.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void saveUser(User user) {
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Collections.singletonList(userRole));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        userRepository.save(user);
    }
}
