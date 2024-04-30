package com.fara.StreamLinedOrderProcessing.repository;

import com.fara.StreamLinedOrderProcessing.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // здесь можно добавить дополнительные методы для работы с товарами
}

// Аналогично создайте репозитории для остальных сущностей: DeliveryRepository, PaymentRepository, EmployeeRepository
