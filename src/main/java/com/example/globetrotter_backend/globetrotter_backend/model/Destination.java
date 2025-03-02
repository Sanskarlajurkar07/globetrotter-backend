package com.example.globetrotter_backend.globetrotter_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "destinations")
public class Destination {
    @Id
    private String id;
    private String city;
    private String country;
    private List<String> clues;
    private List<String> funFact;
    private List<String> trivia;

    public Destination() {}

    public Destination(String city, String country, List<String> clues, List<String> funFact, List<String> trivia) {
        this.city = city;
        this.country = country;
        this.clues = clues;
        this.funFact = funFact;
        this.trivia = trivia;
    }

    // Getters and setters (use IntelliJ shortcut: Alt+Insert > Getter and Setter)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public List<String> getClues() { return clues; }
    public void setClues(List<String> clues) { this.clues = clues; }
    public List<String> getFunFact() { return funFact; }
    public void setFunFact(List<String> funFact) { this.funFact = funFact; }
    public List<String> getTrivia() { return trivia; }
    public void setTrivia(List<String> trivia) { this.trivia = trivia; }
}
