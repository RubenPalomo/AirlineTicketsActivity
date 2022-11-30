package com.airline.AirlineFlight.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airline.AirlineFlight.models.Flight;

public interface FlightsRepository extends MongoRepository<Flight, String> {
}
