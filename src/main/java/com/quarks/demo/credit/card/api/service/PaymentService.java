package com.quarks.demo.credit.card.api.service;

import com.quarks.demo.credit.card.api.model.Payment;

public interface PaymentService {

    public com.quarks.demo.credit.card.api.entity.Payment doPayment(Payment payment);

    public com.quarks.demo.credit.card.api.entity.Payment getPayment(String id);


}
