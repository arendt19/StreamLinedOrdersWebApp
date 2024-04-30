package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Product;
import com.fara.StreamLinedOrderProcessing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setPricePerUnit(updatedProduct.getPricePerUnit());
            return productRepository.save(existingProduct);
        }
            return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            productRepository.delete(optionalProduct.get());
            return true;
        }
            return false;
    }
}
