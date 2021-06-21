package com.quarks.demo.credit.card.api.service;

import com.quarks.demo.credit.card.api.model.Payment;

public interface PaymentService {

    public Payment doPayment(Payment payment);

    public Payment getPayment(String id);


}
