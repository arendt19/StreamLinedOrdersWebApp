package com.fara.StreamLinedOrderProcessing.repository;

import com.fara.StreamLinedOrderProcessing.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    // здесь можно добавить дополнительные методы для работы с товарами
}
