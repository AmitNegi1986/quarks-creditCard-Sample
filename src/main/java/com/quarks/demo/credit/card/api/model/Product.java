package com.quarks.demo.credit.card.api.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;

public class Product {

    public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@NotNull
    public String name;

    @NotNull
    public Double price;

    @JsonbCreator
    public Product(@JsonbProperty("name") String name, @JsonbProperty("price") Double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}
