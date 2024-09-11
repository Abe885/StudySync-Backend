package com.coderscampus.studysync;

import com.coderscampus.studysync.domain.Role;
import com.coderscampus.studysync.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("USER") == null) {
            Role userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName("ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);
        }

        if (roleRepository.findByName("MODERATOR") == null) {
            Role moderatorRole = new Role();
            moderatorRole.setName("MODERATOR");
            roleRepository.save(moderatorRole);
        }
    }
}

