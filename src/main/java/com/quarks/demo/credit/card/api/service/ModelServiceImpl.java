package com.quarks.demo.credit.card.api.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;

import com.quarks.demo.credit.card.api.model.Model;
import com.quarks.demo.credit.card.api.repository.ModelRepository;

@ApplicationScoped
public class ModelServiceImpl  implements ModelService {

    @Inject
    ModelRepository modelRepository;
    
	@Override
	public Model createModel(Model model) {
		modelRepository.persist(model);
        return model;
	}

	@Override
	public Model getModel(String id) {
        return modelRepository.findById(new ObjectId(id));
	}

}
