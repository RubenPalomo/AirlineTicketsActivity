package com.quokka.QuokkaAirline.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quokka.QuokkaAirline.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
