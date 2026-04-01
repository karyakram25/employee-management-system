package net.javaguides.springboot.controller;

import net.javaguides.springboot.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        // simple check (later DB)
        if (username.equals("admin") && password.equals("admin123")) {
            return JwtUtil.generateToken(username);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
