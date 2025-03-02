package com.example.globetrotter_backend.globetrotter_backend.dto;

import java.util.List;

public record GameResponse(String id, List<String> clues, List<String> options) {}
