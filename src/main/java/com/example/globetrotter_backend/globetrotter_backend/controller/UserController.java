package com.example.globetrotter_backend.globetrotter_backend.controller;

import com.example.globetrotter_backend.globetrotter_backend.dto.InviteResponse;
import com.example.globetrotter_backend.globetrotter_backend.dto.ScoreResponse;
import com.example.globetrotter_backend.globetrotter_backend.dto.UserRegistrationRequest;
import com.example.globetrotter_backend.globetrotter_backend.service.InviteService;
import com.example.globetrotter_backend.globetrotter_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private InviteService inviteService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRegistrationRequest request) {
        userService.registerUser(request.username());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{username}/score")
    public ScoreResponse getScore(@PathVariable String username) {
        return userService.getScore(username);
    }

    @GetMapping("/invite/{username}")
    public InviteResponse getInviteLink(@PathVariable String username) {
        String link = inviteService.generateInviteLink(username);
        String imageUrl = inviteService.generateInviteImage(username);
        return new InviteResponse(link, imageUrl);
    }
}