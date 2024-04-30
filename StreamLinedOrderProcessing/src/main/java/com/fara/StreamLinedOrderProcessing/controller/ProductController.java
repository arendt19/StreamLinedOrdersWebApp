package com.fara.StreamLinedOrderProcessing.controller;

import com.fara.StreamLinedOrderProcessing.model.Product;
import com.fara.StreamLinedOrderProcessing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "New product added successfully";
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        productService.updateProduct(productId, updatedProduct);
        return "Product updated successfully";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
    productService.deleteProduct(productId);
        return "Product deleted successfully";
    }
}
