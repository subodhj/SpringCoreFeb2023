package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nt.model.Voter;

public interface IVoterRepo extends JpaRepository<Voter,Integer> {

}
