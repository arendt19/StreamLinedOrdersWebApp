package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Delivery;
import com.fara.StreamLinedOrderProcessing.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getDeliveryById(Long deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        return optionalDelivery.orElse(null);
    }

    @Override
    public Delivery updateDelivery(Long deliveryId, Delivery updatedDelivery) {
        Optional<Delivery> optionalExistingDelivery = deliveryRepository.findById(deliveryId);
        if (optionalExistingDelivery.isPresent()) {
            Delivery existingDelivery = optionalExistingDelivery.get();
            existingDelivery.setOrderId(updatedDelivery.getOrderId());
            existingDelivery.setMethodCode(updatedDelivery.getMethodCode());
            existingDelivery.setDeliveryDate(updatedDelivery.getDeliveryDate());
            existingDelivery.setDeliveryMethod(updatedDelivery.getDeliveryMethod());
            existingDelivery.setCustomerName(updatedDelivery.getCustomerName());
            existingDelivery.setCustomerAddress(updatedDelivery.getCustomerAddress());
            existingDelivery.setCustomerPhone(updatedDelivery.getCustomerPhone());
            existingDelivery.setShippingCost(updatedDelivery.getShippingCost());
            return deliveryRepository.save(existingDelivery);
        }
        return null;
    }

    @Override
    public boolean deleteDelivery(Long deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            deliveryRepository.delete(optionalDelivery.get());
            return true;
        }
        return false;
    }
}
