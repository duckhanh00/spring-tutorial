package com.tutorial.Spring.tutorial.repositories;

import com.tutorial.Spring.tutorial.models.Product;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface ProductRepository {
    String insertProduct(UUID productId, Product product);
    
    default String insertProduct(Product product) {
        UUID id = UUID.randomUUID();
        insertProduct(id, product);
        return product.toString();
    }
    
    List<Product> selectAllProducts();

    Optional<Product> selectProductById(UUID id);

    int deleteProductById(UUID id);

    int updateProductById(UUID id, Product product);
}
