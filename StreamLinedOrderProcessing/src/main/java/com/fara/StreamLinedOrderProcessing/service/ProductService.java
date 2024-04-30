package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    Product updateProduct(Long productId, Product updatedProduct);

    boolean deleteProduct(Long productId);
}
