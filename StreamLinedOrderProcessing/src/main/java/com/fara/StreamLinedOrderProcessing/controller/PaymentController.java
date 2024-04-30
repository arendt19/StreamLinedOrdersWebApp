package com.fara.StreamLinedOrderProcessing.controller;

import com.fara.StreamLinedOrderProcessing.model.Payment;
import com.fara.StreamLinedOrderProcessing.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public String addPayment(@RequestBody Payment payment) {
        paymentService.savePayment(payment);
        return "New payment added successfully";
    }

    @GetMapping("/getAll")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PutMapping("/{paymentId}")
    public String updatePayment(@PathVariable Long paymentId, @RequestBody Payment updatedPayment) {
        Payment payment = paymentService.updatePayment(paymentId, updatedPayment);
        if (payment != null) {
            return "Payment updated successfully";
        } else {
            throw new RuntimeException("Payment not found with id: " + paymentId);
        }
    }

    @DeleteMapping("/{paymentId}")
    public String deletePayment(@PathVariable Long paymentId) {
        boolean deleted = paymentService.deletePayment(paymentId);
        if (deleted) {
            return "Payment deleted successfully";
        } else {
            throw new RuntimeException("Payment not found with id: " + paymentId);
        }
    }
}
