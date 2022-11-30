package com.airline.AirlineFlight.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.airline.AirlineFlight.models.Flight;

public interface FlightsRepository extends MongoRepository<Flight, String> {

    // @Query("{departure:'?0'}")
    // List<Flight> findFlightByDeparture(String departure);

    // @Query("{luggages:'?0'}")
    // List<Flight> findFlightHasLuggages(String hasLuggages);

    // @Query("{airline:'?0'}")
    // List<Flight> findFlightByAirLine(String airline);

    // @Query("{layovers:'?0'}")
    // List<Flight> findFlightByLayovers(int layovers);

    // @Query("{departure:'?0', destination:'?1', airline:'?2', layovers:' $lt:?3',
    // luggages:'?4'}")
    // List<Flight> getFlights(String departure, String destination, String airline,
    // int layovers, String luggages);

    // $cond: [$ne ['?3', null],luggages:'?3' , ]}

    // @Query("{departure:'?0', destination:'?1', airline:'?2', luggages: { cond:
    // {if: { $eq: ['?3', ''] }, then: {$exists: true}, else: '?3' } } }")
    @Query("{departure:'?0', destination:'?1', airline:'?2', luggages:?3}")
    List<Flight> getFlights(String departure, String destination, String airline, String luggages);

    public long count();
}
