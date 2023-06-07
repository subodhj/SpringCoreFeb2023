package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Citizen;

public interface CitizenRepo extends MongoRepository<Citizen, Integer> {

}
