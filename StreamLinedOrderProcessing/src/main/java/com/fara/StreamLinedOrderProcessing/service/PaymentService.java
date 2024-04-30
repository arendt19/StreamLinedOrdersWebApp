package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Payment;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long paymentId);

    Payment updatePayment(Long paymentId, Payment updatedPayment);

    boolean deletePayment(Long paymentId);
}
