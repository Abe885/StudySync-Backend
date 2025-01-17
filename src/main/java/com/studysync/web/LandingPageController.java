package com.studysync.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/")
    public String redirectToLandingPage() {
        return "landing";
    }

    @GetMapping("/landing")
    public String displayLandingPage() {
        return "landing";
    }

}
