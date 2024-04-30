package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Customers;

import java.util.List;

public interface CustomersService {

   Customers saveCustomer(Customers customer);

   List<Customers> getAllCustomers();

   Customers getCustomerById(Long customerId);

   Customers updateCustomer(Long customerId, Customers updatedCustomer);

   boolean deleteCustomer(Long customerId);
}
