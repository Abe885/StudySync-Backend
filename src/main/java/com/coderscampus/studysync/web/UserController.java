package com.coderscampus.studysync.web;

import com.coderscampus.studysync.domain.User;
import com.coderscampus.studysync.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String getRegister(ModelMap model) {
        model.put("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(User user) {
        userService.saveUser(user);
        System.out.println("User saved: " + user); // Add this line for debugging
        return "redirect:/login";
    }
}