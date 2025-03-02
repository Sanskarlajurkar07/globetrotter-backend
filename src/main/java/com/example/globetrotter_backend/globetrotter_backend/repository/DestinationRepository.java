package com.example.globetrotter_backend.globetrotter_backend.repository;

import com.example.globetrotter_backend.globetrotter_backend.model.Destination;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DestinationRepository extends MongoRepository<Destination, String> {
    @Aggregation(pipeline = { "{ $sample: { size: 1 } }" })
    Destination findRandom();
}