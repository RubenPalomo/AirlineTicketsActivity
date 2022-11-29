package com.airline.AirlineUser.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airline.AirlineUser.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
