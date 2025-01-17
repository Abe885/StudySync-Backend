package com.studysync.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ModeratorController {

    @GetMapping("/moderator/dashboard")
    public String getModeratorDashboard() {
        return "/moderator/dashboard";
    }
}
