package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.SportsPerson;

public interface SportsPersonRepo extends MongoRepository<SportsPerson, Long> {

}
