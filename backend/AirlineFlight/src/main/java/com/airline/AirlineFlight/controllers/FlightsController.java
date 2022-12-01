package com.airline.AirlineFlight.controllers;

import java.util.List;
import java.sql.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RestController
@RequestMapping("/flight")
@CrossOrigin
public class FlightsController {
    @Autowired
    private FlightService flightService;

    @GetMapping()
    public List<Flight> getFlights() {
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public Flight findbyId(@PathVariable String id) {
        return flightService.findById(id);
    }

    @GetMapping("/")
    public List<Flight> findFlightsByParams(@RequestParam(required = false) String departure,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String airline, @RequestParam(required = false) Integer layovers,
            @RequestParam(required = false) Date departureDate) {

        HashMap<String, String> map = new HashMap<String, String>();
        if (departure != null) {
            map.put("departure", departure);
        }
        if (destination != null) {
            map.put("destination", destination);
        }
        if (airline != null) {
            map.put("airline", airline);
        }
        if (layovers != null) {
            map.put("layovers", layovers.toString());
        }
        if (departureDate != null) {
            map.put("departureDate", departureDate.toString());
        }

        return flightService.findFlightsByParams(map);
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
