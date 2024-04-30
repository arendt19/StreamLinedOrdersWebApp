package com.fara.StreamLinedOrderProcessing.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    private Long orderId;

    private Integer methodCode;


    private String deliveryDate;

    private String deliveryMethod;


    private String customerName;


    private String customerAddress;


    private String customerPhone;


    private Integer shippingCost;

    public Delivery() {
        // Пустой конструктор требуется для JPA
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(Integer methodCode) {
        this.methodCode = methodCode;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }
}
