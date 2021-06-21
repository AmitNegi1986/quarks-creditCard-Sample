package com.quarks.demo.credit.card.api.repository;


import javax.enterprise.context.ApplicationScoped;
import io.quarkus.mongodb.panache.PanacheMongoRepository;


@ApplicationScoped
public class PaymentRepository implements PanacheMongoRepository<com.quarks.demo.credit.card.api.entity.Payment> {


	/*public Payment findById(String id) {
		
		return find("_id", new ObjectId(id)).firstResult();
	}*/
}
