package com.fara.StreamLinedOrderProcessing.controller;

import com.fara.StreamLinedOrderProcessing.model.Delivery;
import com.fara.StreamLinedOrderProcessing.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/add")
    public String addDelivery(@RequestBody Delivery delivery) {
        deliveryService.saveDelivery(delivery);
        return "New delivery added successfully";
    }

    @GetMapping("/getAll")
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{deliveryId}")
    public Delivery getDeliveryById(@PathVariable Long deliveryId) {
        return deliveryService.getDeliveryById(deliveryId);
    }

    @PutMapping("/{deliveryId}")
    public String updateDelivery(@PathVariable Long deliveryId, @RequestBody Delivery updatedDelivery) {
        Delivery updated = deliveryService.updateDelivery(deliveryId, updatedDelivery);
        if (updated != null) {
            return "Delivery updated successfully";
        } else {
            throw new RuntimeException("Delivery not found with id: " + deliveryId);
        }
    }

    @DeleteMapping("/{deliveryId}")
    public String deleteDelivery(@PathVariable Long deliveryId) {
        boolean deleted = deliveryService.deleteDelivery(deliveryId);
        if (deleted) {
            return "Delivery deleted successfully";
        } else {
            throw new RuntimeException("Delivery not found with id: " + deliveryId);
        }
    }
}
