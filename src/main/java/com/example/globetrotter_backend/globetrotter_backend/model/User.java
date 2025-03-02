package com.example.globetrotter_backend.globetrotter_backend.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User{
    @Id
    private String username;
    private int correctAnswers;
    private int incorrectAnswers;

    public User() {}

    public User(String username, int correctAnswers, int incorrectAnswers) {
        this.username = username;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }

    // Getters and setters (use Alt+Insert in IntelliJ)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public int getCorrectAnswers() { return correctAnswers; }
    public void setCorrectAnswers(int correctAnswers) { this.correctAnswers = correctAnswers; }
    public int getIncorrectAnswers() { return incorrectAnswers; }
    public void setIncorrectAnswers(int incorrectAnswers) { this.incorrectAnswers = incorrectAnswers; }
}