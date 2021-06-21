package com.quarks.demo.credit.card.api.entity;

import java.util.Date;
import java.util.List;

import com.quarks.demo.credit.card.api.model.CardType;
import com.quarks.demo.credit.card.api.model.Product;
import com.quarks.demo.credit.card.api.model.Store;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "payments")
public class Payment extends PanacheMongoEntity {
	
	public Payment() {
		super();
	}

	
	CardType cardType;

	String cardNumber;

	Date expirationDate;

	Store store;
	
	List<Product> products;

	public Payment(CardType cardType, String cardNumber,
			Date expirationDate, Store store,
			List<Product> products) {
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.store = store;
		this.products = products;
	}

	/*@Override
	public String toString() {
		return String.format("Payment [cardType=%s, cardNumber=%s, expirationDate=%s, store=%s, products=%s, id=%s]",
				cardType, cardNumber, expirationDate, store, products, id);
	}*/
}
