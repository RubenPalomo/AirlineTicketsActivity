package com.airline.AirlineFlight.controllers;

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
import com.airline.AirlineFlight.models.HttpResponse;
import com.airline.AirlineFlight.service.FlightService;

@RestController
@RequestMapping("/flight")
@CrossOrigin
public class FlightsController {
    @Autowired
    private FlightService flightService;

    @GetMapping()
    public HttpResponse getFlights() {
        try {
            return new HttpResponse(flightService.findAll().toString(), "Flights found", true);
        } catch (Exception e) {
            return new HttpResponse("", "No flight exist", false);
        }
    }

    @GetMapping("/{id}")
    public HttpResponse findbyId(@PathVariable String id) {
        try {
            return new HttpResponse(flightService.findById(id).toString(), "Flight found", true);
        } catch (Exception e) {
            return new HttpResponse("", "Flight doesn't exist", false);
        }
    }

    @GetMapping("/")
    public HttpResponse findFlightsByParams(@RequestParam(required = false) String departure,
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

        String resultString = flightService.findFlightsByParams(map).toString();
        try {
            if (resultString == "") {
                return new HttpResponse(resultString, "No flights finded", true);
            } else {
                return new HttpResponse(resultString, "Flights finded", true);
            }
        } catch (Exception e) {
            return new HttpResponse("", "Research completed incorrectly", true);
        }
    }

    @PostMapping()
    public HttpResponse save(@RequestBody Flight flight) {
        try {
            findbyId(flight.getFlightId());
            return new HttpResponse("", "Flight already exists", false);
        } catch (Exception e) {
            flightService.save(flight);
            return new HttpResponse("", "Flight correctly created", true);
        }
    }

    @PutMapping("/{id}")
    public HttpResponse update(@PathVariable String id, @RequestBody Flight flight) {
        try {
            findbyId(id);
            flightService.save(flight);
            return new HttpResponse("", "Flight correctly updated", true);
        } catch (Exception e) {
            return new HttpResponse("", "Flight doesn't exists", false);
        }
    }

    @DeleteMapping("/{id}")
    public HttpResponse deleteById(@PathVariable String id) {
        try {
            findbyId(id);
            flightService.deleteById(id);
            return new HttpResponse("", "Flight correctly deleted", true);
        } catch (Exception e) {
            return new HttpResponse("", "Flight doesn't exists", false);
        }
    }
}
