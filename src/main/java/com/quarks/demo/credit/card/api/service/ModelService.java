package com.quarks.demo.credit.card.api.service;

import com.quarks.demo.credit.card.api.model.Model;
import com.quarks.demo.credit.card.api.model.Payment;

public interface ModelService {

	   public Model createModel(Model model);

	    public Model getModel(String id);
}
