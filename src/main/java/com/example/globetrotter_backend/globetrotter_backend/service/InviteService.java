package com.example.globetrotter_backend.globetrotter_backend.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class InviteService {
    public String generateInviteLink(String username) {
        return "https://globetrotter-app.com/play?invite=" + Base64.getEncoder().encodeToString(username.getBytes());
    }

    public String generateInviteImage(String username) {
        // Placeholder: Use Java2D or an external API (e.g., Cloudinary) for image generation
        return "https://example.com/invite-image/" + username + ".png";
    }
}