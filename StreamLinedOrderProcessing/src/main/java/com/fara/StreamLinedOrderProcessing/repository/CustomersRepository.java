package com.fara.StreamLinedOrderProcessing.repository;

import com.fara.StreamLinedOrderProcessing.model.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Long> {
    // Здесь могут быть дополнительные методы репозитория, если необходимо
}
