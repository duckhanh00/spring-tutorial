package com.tutorial.Spring.tutorial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import com.tutorial.Spring.tutorial.models.Product;
import com.tutorial.Spring.tutorial.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository; 

    @Autowired
    public ProductService(@Qualifier("productAccess") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(Product product) {
        return productRepository.insertProduct(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.selectAllProducts();
    }

    public Optional<Product> getProductById(UUID productId) {
        return productRepository.selectProductById(productId);
    }

    public int deleteProductById(UUID productId) {
        return productRepository.deleteProductById(productId);
    }

    public int updateProductById(UUID productId, Product newProduct) {
        return productRepository.updateProductById(productId, newProduct);
    }
}
