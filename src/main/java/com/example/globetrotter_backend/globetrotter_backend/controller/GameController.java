package com.example.globetrotter_backend.globetrotter_backend.controller;

import com.example.globetrotter_backend.globetrotter_backend.dto.AnswerRequest;
import com.example.globetrotter_backend.globetrotter_backend.dto.AnswerResponse;
import com.example.globetrotter_backend.globetrotter_backend.dto.GameResponse;
import com.example.globetrotter_backend.globetrotter_backend.dto.ScoreResponse;
import com.example.globetrotter_backend.globetrotter_backend.model.Destination;
import com.example.globetrotter_backend.globetrotter_backend.repository.DestinationRepository;
import com.example.globetrotter_backend.globetrotter_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private DestinationRepository destinationRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/start")
    public GameResponse startGame() {
        Destination target = destinationRepo.findRandom();
        List<String> clues = getRandomClues(target.getClues(), 2);
        List<String> options = generateOptions(target);
        return new GameResponse(target.getId(), clues, options);
    }

    @PostMapping("/answer")
    public AnswerResponse submitAnswer(@RequestBody AnswerRequest request) {
        Destination target = destinationRepo.findById(request.destinationId()).orElseThrow();
        boolean isCorrect = target.getCity().equals(request.guess());
        userService.updateScore(request.username(), isCorrect);
        String funFact = target.getFunFact().get(new Random().nextInt(target.getFunFact().size()));
        return new AnswerResponse(isCorrect, funFact);
    }

    @GetMapping("/score")
    public ScoreResponse getScore(@RequestParam String username) {
        return userService.getScore(username);
    }

    private List<String> getRandomClues(List<String> clues, int count) {
        Collections.shuffle(clues);
        return clues.subList(0, Math.min(count, clues.size()));
    }

    private List<String> generateOptions(Destination target) {
        List<Destination> all = destinationRepo.findAll();
        Collections.shuffle(all);
        List<String> options = all.stream()
                .filter(d -> !d.getId().equals(target.getId()))
                .limit(3)
                .map(Destination::getCity)
                .collect(Collectors.toList());
        options.add(target.getCity());
        Collections.shuffle(options);
        return options;
    }
}