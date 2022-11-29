package com.quokka.AirlineFlight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quokka.AirlineFlight.models.Flight;
import com.quokka.AirlineFlight.repositories.FlightsRepository;

@Component
public class FlightService {
    @Autowired
    FlightsRepository flightRepository;

    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findById(String id) {
        return flightRepository.findById(id);
    }

    public void deleteById(String id) {
        flightRepository.deleteById(id);
    }
}
