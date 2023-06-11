package com.nt.service;

import java.util.List;

import com.nt.document.Actor;

public interface IActorsAssociationMgmtService {

	String registerActor(Actor actor);

	String registerActor(List<Actor> actors);

	List<Actor> getActor();

	List<Actor> getActor(String role);

	Actor getActor(int id);

	String modifyActorAddrsAndContactNoById(int id, String addrs, long contactNo);

	String modifyActorPayByRoleAndAge(String role, int age, double amt);

	String saveOrUpdateActorByAgeRange(int minAge, int maxAge, double pay, long contactNo, String addrs);

	String removeActorByAgeGTE(int age);

	String removeActorsByPayRange(double minPay, double maxPay);

}
