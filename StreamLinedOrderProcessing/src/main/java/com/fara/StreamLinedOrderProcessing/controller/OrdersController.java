package com.fara.StreamLinedOrderProcessing.controller;

import com.fara.StreamLinedOrderProcessing.model.Orders;
import com.fara.StreamLinedOrderProcessing.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Orders order) {
        ordersService.saveOrder(order);
        return ResponseEntity.ok("New order is added");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        Orders order = ordersService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long orderId, @RequestBody Orders updatedOrder) {
        Orders updated = ordersService.updateOrder(orderId, updatedOrder);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        boolean deleted = ordersService.deleteOrder(orderId);
        if (deleted) {
            return ResponseEntity.ok("Order deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
