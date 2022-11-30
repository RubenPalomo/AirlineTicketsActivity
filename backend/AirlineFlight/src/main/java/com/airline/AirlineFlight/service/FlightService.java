package com.airline.AirlineFlight.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.RealmRuleSet;
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

    public Optional<Flight> findById(String id) {
        return flightRepository.findById(id);
    }

    public void deleteById(String id) {
        flightRepository.deleteById(id);
    }

    // public List<Flight> findFlightByDeparture(String departure) {
    // return flightRepository.findFlightByDeparture(departure);
    // }

    // public List<Flight> findFlightHasLuggages(String hasLuggages) {
    // return flightRepository.findFlightHasLuggages(hasLuggages);
    // }

    // public List<Flight> findFlightByAirLine(String airline) {
    // return flightRepository.findFlightByAirLine(airline);
    // }

    // public List<Flight> findFlightByLayovers(int layovers) {
    // return flightRepository.findFlightByLayovers(layovers);
    // }

    // public List<Flight> getFlights(String departure, String destination, String
    // airline, int layovers,
    // String luggages) {
    // return flightRepository.getFlights(departure, destination, airline, layovers,
    // luggages);
    // }

    public List<Flight> getFlights(String departure, String destination, String airline,
            String luggages) {

        System.out.println(departure + destination + airline + luggages);
        return flightRepository.getFlights(departure, destination, airline, luggages);
    }
}
