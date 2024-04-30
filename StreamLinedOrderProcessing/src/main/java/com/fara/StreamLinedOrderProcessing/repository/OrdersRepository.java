package com.fara.StreamLinedOrderProcessing.repository;

import com.fara.StreamLinedOrderProcessing.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // Здесь могут быть другие методы запросов к базе данных
}
