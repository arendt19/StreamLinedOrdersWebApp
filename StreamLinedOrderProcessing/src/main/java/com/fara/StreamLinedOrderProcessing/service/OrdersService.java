package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Orders;

import java.util.List;

public interface OrdersService {
    Orders saveOrder(Orders order);
    List<Orders> getAllOrders();
    Orders getOrderById(Long orderId);
    Orders updateOrder(Long orderId, Orders updatedOrder);
    boolean deleteOrder(Long orderId);
}
