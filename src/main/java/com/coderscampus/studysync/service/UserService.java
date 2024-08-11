package com.coderscampus.studysync.service;

import com.coderscampus.studysync.domain.Role;
import com.coderscampus.studysync.domain.User;
import com.coderscampus.studysync.repository.RoleRepository;
import com.coderscampus.studysync.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

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


    public void saveUser(User user, String roleName) {
        Role role = roleRepository.findByName(roleName);
        user.setRoles(Collections.singletonList(role));

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public void updateUserProfile(User user, MultipartFile profilePicture, List<String> subjects) throws IOException {
        if (!profilePicture.isEmpty()) {
            user.setProfilePicture(profilePicture.getBytes());
        }

        user.setSubjects(subjects);
        userRepository.save(user);
    }

}
