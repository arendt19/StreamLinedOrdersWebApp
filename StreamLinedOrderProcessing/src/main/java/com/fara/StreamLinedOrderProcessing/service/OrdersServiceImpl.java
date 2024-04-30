package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Orders;
import com.fara.StreamLinedOrderProcessing.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders getOrderById(Long orderId) {
        Optional<Orders> optionalOrder = ordersRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    @Override
    public Orders updateOrder(Long orderId, Orders updatedOrder) {
        Optional<Orders> optionalExistingOrder = ordersRepository.findById(orderId);
        if (optionalExistingOrder.isPresent()) {
            Orders existingOrder = optionalExistingOrder.get();
            existingOrder.setName(updatedOrder.getName());
            existingOrder.setAddress(updatedOrder.getAddress());
            // Set other fields as needed
            return ordersRepository.save(existingOrder);
        }
        return null;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        Optional<Orders> optionalOrder = ordersRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            ordersRepository.delete(optionalOrder.get());
            return true;
        }
        return false;
    }
}
