package com.airline.AirlineFlight.repositories;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;

import com.airline.AirlineFlight.models.Flight;

@Component
public interface FlightsRepository {

    List<Flight> findFlightsByParams(HashMap<String, String> map);

    List<Flight> findAll();

    Flight findById(String id);

    void save(Flight flight);

    void deleteById(String id);
}
