package com.example.globetrotter_backend.globetrotter_backend.repository;

import com.example.globetrotter_backend.globetrotter_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {}
