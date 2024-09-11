package com.coderscampus.studysync.service;

import com.coderscampus.studysync.domain.Role;
import com.coderscampus.studysync.domain.User;
import com.coderscampus.studysync.repository.RoleRepository;
import com.coderscampus.studysync.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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

    @Transactional
    public void save(User user, String roleName) {
        Role role = roleRepository.findByName(roleName);
        user.setRoles(Collections.singletonList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    @Transactional
    public void updateUserProfile(User user, MultipartFile profilePicture, List<String> subjects) throws IOException {
        if (!profilePicture.isEmpty()) {
            String imageUrl = saveProfilePicture(profilePicture);
            user.setProfileImageUrl(imageUrl);
        }
        user.setSubjects(subjects);

        userRepository.save(user);
    }

    private String saveProfilePicture(MultipartFile profilePicture) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + profilePicture.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/profileImages");
        Files.write(path, profilePicture.getBytes());

        return fileName;
    }
}
