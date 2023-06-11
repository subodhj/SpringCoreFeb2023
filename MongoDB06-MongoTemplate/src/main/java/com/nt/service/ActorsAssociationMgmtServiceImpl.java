package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.Actor;

@Service("aamService")
public class ActorsAssociationMgmtServiceImpl implements IActorsAssociationMgmtService {

	@Autowired
	private MongoTemplate template;

	// 1. Save Actor.
	@Override
	public String registerActor(Actor actor) {
//		return "Actor document saved with Id: " + template.save(actor).getId();
//		return "Actor document saved with Id: " + template.save(actor, "Actor").getId();
		return "Actor document saved with Id: " + template.insert(actor).getId();
	}

	// 2. Save multiple Actors.
	@Override
	public String registerActor(List<Actor> actors) {
		return template.insert(actors, Actor.class).size() + " Actor documents saved.";
	}

	// 3. Get all Actors.
	@Override
	public List<Actor> getActor() {
		return template.findAll(Actor.class);
	}

	// 4. Get Actors by role.
	@Override
	public List<Actor> getActor(String role) {
		Query query = new Query();
		query.addCriteria(Criteria.where("role").is(role));
		return template.find(query, Actor.class);
	}

	// 5. Get Actor by Id.
	@Override
	public Actor getActor(int id) {
		return template.findById(id, Actor.class);
	}

	// 6. Modify Actor address & contactNo by Id.
	@Override
	public String modifyActorAddrsAndContactNoById(int id, String addrs, long contactNo) {
		// create Query object to retrieve the doc
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		// create Update object to modify document.
		Update update = new Update();
		update.set("addrs", addrs);
		update.set("contactNo", contactNo);
		// find & modify document.
		Actor actor = template.findAndModify(query, update, Actor.class);
		return actor != null ? "Actor document modified." : "Actor document not found.";
	}

	// 7. Modify multiple Actors pay using role & age as the criteria.
	@Override
	public String modifyActorPayByRoleAndAge(String role, int age, double amt) {
		// create Query object to retrieve multiple documents.
		Query query = new Query();
		query.addCriteria(Criteria.where("role").is(role).andOperator(Criteria.where("age").gte(age)));
		// create Update object to modify multiple document.
		Update update = new Update();
		update.set("pay", amt);
		// modify multiple documents.
		UpdateResult result = template.updateMulti(query, update, Actor.class);
		return result.getModifiedCount() + " Actor documents updated.";
	}

	// 8. Modify multi Actors pay, phoneNo & addrs based on age range as criteria.
	@Override
	public String saveOrUpdateActorByAgeRange(int minAge, int maxAge, double pay, long contactNo, String addrs) {
		// create Query object to retrieve documents.
		Query query = new Query();
		query.addCriteria(Criteria.where("age").gte(minAge).andOperator(Criteria.where("age").lte(maxAge)));
		// create Update object to update documents.
		Update update = new Update();
		update.set("pay", pay);
		update.set("contactNo", contactNo);
		update.set("addrs", addrs);
		// insert or update documents.
		UpdateResult result = template.upsert(query, update, Actor.class);
		return result.getModifiedCount() + " Actor documents updated.";
	}

	// 9. Delete Actor by greater than or equal to age.
	@Override
	public String removeActorByAgeGTE(int age) {
		Query query = new Query();
		query.addCriteria(Criteria.where("age").gte(age));
		Actor actor = template.findAndRemove(query, Actor.class);
		return "Deleted Actor with Id: " + actor.getId();
	}

	// 10. Delete all Actors docs which match given condition.
	@Override
	public String removeActorsByPayRange(double minPay, double maxPay) {
		Query query = new Query();
		query.addCriteria(Criteria.where("pay").gte(minPay).andOperator(Criteria.where("pay").lte(maxPay)));
		List<Actor> actorsList = template.findAllAndRemove(query, Actor.class);
		return actorsList.size() + " Actors removed." + "\n" + actorsList;
	}

}// class
