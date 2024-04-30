package com.fara.StreamLinedOrderProcessing.repository;

import com.fara.StreamLinedOrderProcessing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // здесь можно добавить дополнительные методы для работы с товарами
}

