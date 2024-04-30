package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Customers;
import com.fara.StreamLinedOrderProcessing.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public Customers saveCustomer(Customers customer) {
        return customersRepository.save(customer);
    }

    @Override
    public List<Customers> getAllCustomers() {
        // Преобразуем Iterable<Customers> в List<Customers>
        return (List<Customers>) customersRepository.findAll();
    }

    @Override
    public Customers getCustomerById(Long customerId) {
        Optional<Customers> optionalCustomer = customersRepository.findById(customerId);
        return optionalCustomer.orElse(null); // Вернем null, если клиент не найден
    }

    @Override
    public Customers updateCustomer(Long customerId, Customers updatedCustomer) {
        Optional<Customers> optionalExistingCustomer = customersRepository.findById(customerId);
        if (optionalExistingCustomer.isPresent()) {
            Customers existingCustomer = optionalExistingCustomer.get();
            // Обновляем только те поля, которые переданы в updatedCustomer
            existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
            existingCustomer.setCompanyName(updatedCustomer.getCompanyName());
            existingCustomer.setCustomerPhone(updatedCustomer.getCustomerPhone());
            existingCustomer.setCustomerAddress(updatedCustomer.getCustomerAddress());
            return customersRepository.save(existingCustomer);
        }
        return null; // Возвращаем null, если клиент не найден
    }

    @Override
    public boolean deleteCustomer(Long customerId) {
        Optional<Customers> optionalCustomer = customersRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            customersRepository.delete(optionalCustomer.get());
            return true; // Успешно удален
        }
        return false; // Клиент не найден или не удалось удалить
    }
}
