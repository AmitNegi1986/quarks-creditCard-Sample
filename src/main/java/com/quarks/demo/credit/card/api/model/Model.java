package com.quarks.demo.credit.card.api.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "model")
public class Model extends PanacheMongoEntity {

	  public String name;
	  public String swordName;	  
	  private Store store;

	  public Model() {

	  }

	  public Model(String name, String swordName, Store store) {
	    this.name = name;
	    this.swordName = swordName;
	    this.store = store;
	  }

}
