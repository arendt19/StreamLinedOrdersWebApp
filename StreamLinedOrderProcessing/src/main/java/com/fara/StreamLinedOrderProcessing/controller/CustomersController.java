package com.fara.StreamLinedOrderProcessing.controller;

import com.fara.StreamLinedOrderProcessing.model.Customers;
import com.fara.StreamLinedOrderProcessing.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customers customer) {
        customersService.saveCustomer(customer);
        return "New customer is added";
    }

    @GetMapping("/getAll")
    public List<Customers> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customers getCustomerById(@PathVariable Long customerId) {
        return customersService.getCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public String updateCustomer(@PathVariable Long customerId, @RequestBody Customers updatedCustomer) {
        customersService.updateCustomer(customerId, updatedCustomer);
        return "Customer updated successfully";
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        customersService.deleteCustomer(customerId);
        return "Customer deleted successfully";
    }
}
