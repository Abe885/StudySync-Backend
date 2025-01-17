package com.studysync.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLongin(){
        return "login";
    }

    @PostMapping("/login")
    public String postLogin() {
        return "user/dashboard";
    }
}
