package com.quarks.demo.credit.card.api.repository;


import javax.enterprise.context.ApplicationScoped;

import com.quarks.demo.credit.card.api.model.Model;

import io.quarkus.mongodb.panache.PanacheMongoRepository;


@ApplicationScoped
public class ModelRepository implements PanacheMongoRepository<Model> {


	
}
