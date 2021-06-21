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

@MongoEntity(collection = "payments")
public class Payment extends PanacheMongoEntity {
	
	public Payment() {
		super();
	}

	@NotNull
	@JsonbProperty("cardType")
	public CardType cardType;

	@NotNull
	@JsonbProperty("cardNumber")
	public String cardNumber;

	@NotNull
	@JsonbProperty("expirationDate")
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	public Date expirationDate;

	@NotNull
	@JsonbProperty("store") 
	public Store store;

	@NotEmpty
	@JsonbProperty("products") 
	public List<Product> products;

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

	@Override
	public String toString() {
		return String.format("Payment [cardType=%s, cardNumber=%s, expirationDate=%s, store=%s, products=%s, id=%s]",
				cardType, cardNumber, expirationDate, store, products, id);
	}

}
