package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Medal;

public interface MedalRepo extends MongoRepository<Medal, String> {

}
