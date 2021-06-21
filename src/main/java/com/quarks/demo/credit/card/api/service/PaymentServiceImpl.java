package com.quarks.demo.credit.card.api.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;
import  static io.quarkus.mongodb.panache.runtime.JavaMongoOperations.INSTANCE;

import com.quarks.demo.credit.card.api.model.CardType;
import com.quarks.demo.credit.card.api.model.Payment;
import com.quarks.demo.credit.card.api.model.Store;
import com.quarks.demo.credit.card.api.repository.PaymentRepository;



@ApplicationScoped
public class PaymentServiceImpl implements PaymentService {

    @Inject
    PaymentRepository paymentRepository;

    @Override
    public com.quarks.demo.credit.card.api.entity.Payment doPayment(Payment payment) {
    	com.quarks.demo.credit.card.api.entity.Payment paymentEntity = new com.quarks.demo.credit.card.api.entity.Payment(payment.getCardType(), payment.getCardNumber(), payment.getExpirationDate(),
				payment.getStore(), payment.getProducts());
         paymentRepository.persist(paymentEntity);
         return paymentEntity;
    }

    @Override
    public com.quarks.demo.credit.card.api.entity.Payment getPayment(String id) {
    	return paymentRepository.findById(new ObjectId(id));
        //return paymentRepository.findById(new ObjectId(id));
    }

    
}
