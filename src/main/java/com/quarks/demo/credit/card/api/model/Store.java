package com.quarks.demo.credit.card.api.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;

public class Store {
	
    public Store() {
		super();		
	}

	@NotNull
    public String name;

    @JsonbCreator
    public Store(@JsonbProperty("name") String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Store [name=%s]", name);
    }

}
