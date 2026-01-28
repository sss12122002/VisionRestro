package com.visionrestro.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.visionrestro.entity.User;
import com.visionrestro.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://vision-restro.netlify.app/") // Vite port
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {

        String username = data.get("username");
        String password = data.get("password");

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Login successful"
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of(
                    "status", "error",
                    "message", "Invalid username or password"
            ));
        }
    }
}
