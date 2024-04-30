package com.fara.StreamLinedOrderProcessing.model;
import jakarta.persistence.*;

@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int productId;


    private String productName;


    private double pricePerUnit;

    public Product() {
        // Пустой конструктор требуется для JPA
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
