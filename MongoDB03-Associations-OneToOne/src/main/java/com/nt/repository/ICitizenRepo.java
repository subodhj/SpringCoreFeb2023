package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Citizen;

public interface ICitizenRepo extends MongoRepository<Citizen, Integer> {

}
