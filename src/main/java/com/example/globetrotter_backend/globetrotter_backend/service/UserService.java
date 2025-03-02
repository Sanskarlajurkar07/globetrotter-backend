package com.example.globetrotter_backend.globetrotter_backend.service;

import com.example.globetrotter_backend.globetrotter_backend.dto.ScoreResponse;
import com.example.globetrotter_backend.globetrotter_backend.model.User;
import com.example.globetrotter_backend.globetrotter_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void updateScore(String username, boolean isCorrect) {
        User user = userRepo.findById(username).orElse(new User(username, 0, 0));
        if (isCorrect) user.setCorrectAnswers(user.getCorrectAnswers() + 1);
        else user.setIncorrectAnswers(user.getIncorrectAnswers() + 1);
        userRepo.save(user);
    }
    public ScoreResponse getScore(String username) {
        User user = userRepo.findById(username).orElse(new User(username, 0, 0));
        return new ScoreResponse(user.getCorrectAnswers(), user.getIncorrectAnswers());
    }

    public void registerUser(String username) {
        if (!userRepo.existsById(username)) {
            userRepo.save(new User(username, 0, 0));
        }
    }
}