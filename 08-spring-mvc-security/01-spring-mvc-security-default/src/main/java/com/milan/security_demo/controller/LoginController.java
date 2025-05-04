package com.milan.security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLogin() {
        return "fancy-login";
    }

    // Add a request mapping for access denied
    @GetMapping("access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
