package com.coderscampus.studysync.web;

import com.coderscampus.studysync.domain.User;
import com.coderscampus.studysync.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
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
        return "redirect:/login";
    }

}
