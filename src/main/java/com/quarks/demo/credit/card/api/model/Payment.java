package com.quarks.demo.credit.card.api.model;

import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Payment {
	
	public Payment() {
		super();
	}

	@NotNull
	@JsonbProperty("cardType")
	CardType cardType;

	@NotNull
	@JsonbProperty("cardNumber")
	String cardNumber;

	@NotNull
	@JsonbProperty("expirationDate")
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	Date expirationDate;

	@NotNull
	@JsonbProperty("store") 
	Store store;

	@NotEmpty
	@JsonbProperty("products") 
	List<Product> products;

	@JsonbCreator
	public Payment(@JsonbProperty("cardType") CardType cardType, @JsonbProperty("cardNumber") String cardNumber,
			@JsonbProperty("expirationDate") Date expirationDate, @JsonbProperty("store") Store store,
			@JsonbProperty("products") List<Product> products) {
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.store = store;
		this.products = products;
	}

	
	public CardType getCardType() {
		return cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public Store getStore() {
		return store;
	}

	public List<Product> getProducts() {
		return products;
	}


}
