package com.airline.AirlineFlight.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.AirlineFlight.models.Flight;
import com.airline.AirlineFlight.service.FlightService;
import com.fasterxml.jackson.annotation.OptBoolean;

@RestController
@RequestMapping("/flight")
public class FlightsController {
    @Autowired
    private FlightService flightService;

    @GetMapping()
    public List<Flight> getFlights() {
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public Flight findbyId(@PathVariable String id) {
        return flightService.findById(id).get();
    }

    // @GetMapping("/departure:{departure}")
    // public List<Flight> findFlightByDeparture(@PathVariable String departure) {
    // return flightService.findFlightByDeparture(departure);
    // }

    // @GetMapping("/luggages:{hasLuggages}")
    // public List<Flight> findFlightHasLuggages(@PathVariable String hasLuggages) {
    // return flightService.findFlightHasLuggages(hasLuggages);
    // }

    // @GetMapping("/airline:{airline}")
    // public List<Flight> findFlightByAirLine(@PathVariable String airline) {
    // return flightService.findFlightByAirLine(airline);
    // }

    // @GetMapping("/layovers:{layovers}")
    // public List<Flight> findFlightByLayovers(@PathVariable int layovers) {
    // return flightService.findFlightByLayovers((layovers));
    // }

    @GetMapping("/")
    public List<Flight> getFlights(@RequestParam Optional<String> departure, @RequestParam Optional<String> destination,
            @RequestParam Optional<String> airline, @RequestParam Optional<String> layovers,
            @RequestParam Optional<String> luggages) {
        // return flightService.getFlights(departure.orElse("%"),
        // destination.orElse("%"), airline.orElse("%"),
        // Integer.parseInt(layovers.orElse("100")), luggages.orElse("%"));

        System.out.println(luggages.orElse(null));

        return flightService.getFlights(departure.orElse("/.*/"), destination.orElse("/.*/"), airline.orElse("/"),
                luggages.orElse("-1"));
    }

    @PostMapping()
    public void save(@RequestBody Flight flight) {
        try {
            findbyId(flight.getFlightId());
            return;
        } catch (Exception e) {
            flightService.save(flight);
        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Flight flight) {
        flightService.save(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        flightService.deleteById(id);
    }
}
