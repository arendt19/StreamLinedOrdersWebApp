package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Payment;
import com.fara.StreamLinedOrderProcessing.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    @Override
    public Payment updatePayment(Long paymentId, Payment updatedPayment) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payment existingPayment = optionalPayment.get();
            existingPayment.setOrderId(updatedPayment.getOrderId()); // Используем setOrderId
            existingPayment.setDeliveryId(updatedPayment.getDeliveryId());
            existingPayment.setPaymentMethod(updatedPayment.getPaymentMethod());
            existingPayment.setPaymentAmount(updatedPayment.getPaymentAmount());
            existingPayment.setPaymentDate(updatedPayment.getPaymentDate());
            existingPayment.setCardNumber(updatedPayment.getCardNumber());
            existingPayment.setOwnerName(updatedPayment.getOwnerName());
            return paymentRepository.save(existingPayment);
        } else {
            return null;
        }
    }


    @Override
    public boolean deletePayment(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            paymentRepository.delete(optionalPayment.get());
            return true;
        } else {
            return false;
        }
    }
}
