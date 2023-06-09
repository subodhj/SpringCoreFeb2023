package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.SportsPerson;

public interface ISportsPersonRepo extends MongoRepository<SportsPerson, Long> {

}
