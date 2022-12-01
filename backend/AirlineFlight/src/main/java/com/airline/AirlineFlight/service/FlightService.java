package com.airline.AirlineFlight.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airline.AirlineFlight.models.Flight;
import com.airline.AirlineFlight.repositories.FlightsRepository;

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

    public Flight findById(String id) {
        return flightRepository.findById(id);
    }

    public void deleteById(String id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> findFlightsByParams(HashMap<String, String> map) {
        return flightRepository.findFlightsByParams(map);
    }
}
