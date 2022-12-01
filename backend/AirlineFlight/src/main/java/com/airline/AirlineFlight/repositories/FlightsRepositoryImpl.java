package com.airline.AirlineFlight.repositories;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.airline.AirlineFlight.models.Flight;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Component;

@Component
public class FlightsRepositoryImpl implements FlightsRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Flight> findFlightsByParams(HashMap<String, String> map) {
        Query query = new Query();

        for (String key : map.keySet()) {
            System.out.println("key: " + key + " value: " + map.get(key));
            query.addCriteria(Criteria.where(key).regex(map.get(key)));
        }
        return mongoTemplate.find(query, Flight.class);
    }

    @Override
    public List<Flight> findAll() {
        return mongoTemplate.findAll(Flight.class);
    }

    @Override
    public Flight findById(String id) {
        return mongoTemplate.findById(id, Flight.class);
    }

    @Override
    public void save(Flight flight) {
        mongoTemplate.save(flight);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(mongoTemplate.findById(id, Flight.class));
    }
}
