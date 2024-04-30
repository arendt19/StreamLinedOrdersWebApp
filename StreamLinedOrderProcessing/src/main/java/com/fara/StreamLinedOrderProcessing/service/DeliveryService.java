package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery saveDelivery(Delivery delivery);
    List<Delivery> getAllDeliveries();
    Delivery getDeliveryById(Long deliveryId);
    Delivery updateDelivery(Long deliveryId, Delivery updatedDelivery);
    boolean deleteDelivery(Long deliveryId);
}
