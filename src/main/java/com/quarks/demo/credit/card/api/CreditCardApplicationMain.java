package com.quarks.demo.credit.card.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.quarks.demo.credit.card.api.model.CardType;
import com.quarks.demo.credit.card.api.model.Payment;
import com.quarks.demo.credit.card.api.model.Product;
import com.quarks.demo.credit.card.api.model.Store;
import com.quarks.demo.credit.card.api.repository.PaymentRepository;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CreditCardApplicationMain  {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CreditCardApplicationMain.class);

	public static void main(String... args) {
	        Quarkus.run(MyApp.class, args);
	    }

	  
	    public static class MyApp implements QuarkusApplication {
	    	@Inject
	    	PaymentRepository paymentRepository;
	    	 
	        @Override
	        public int run(String... args) throws Exception {
	        	LOGGER.info("Do startup logic here");
	    		java.util.List<Product> list1 = new ArrayList<>();
	    		list1.add(new Product("Bike", 115.50D));
	    		list1.add(new Product("iPhone 6S", 199.80D));

	    		java.util.List<Product> list2 = new ArrayList<>();
	    		list2.add(new Product("Nexus 9", 327.50D));
	    		list2.add(new Product("Motorola Moto X 2014", 112.90D));
	    		list2.add(new Product("iPhone 6S", 199.80D));

	    		java.util.List<Product> list3 = new ArrayList<>();
	    		list3.add(new Product("Nexus 9", 327.50D));
	    		list3.add(new Product("Nexus 9", 327.50D));
	    		list3.add(new Product("Motorola Moto X 2014", 199.80D));
	    		list3.add(new Product("iPhone 6S", 199.80D));

	    		Date expirationDate = Calendar.getInstance().getTime();
	    		
	    		Payment payment = new Payment(CardType.AMERICAN_EXPRESS, "4485317326500091", expirationDate,
	    				new Store("Walmart"), list1);

	    		paymentRepository.persist(payment);

	    		payment = new Payment(CardType.VISA, "4485317326500090", expirationDate, new Store("BestBuy"), list2);
	    		paymentRepository.persist(payment);

	    		payment = new Payment(CardType.MASTERCARD, "4485317326500092", expirationDate, new Store("Amazon"), list3);
	    		paymentRepository.persist(payment);
	            Quarkus.waitForExit();
	            return 0;
	        }
	    }
	    
	    
}
