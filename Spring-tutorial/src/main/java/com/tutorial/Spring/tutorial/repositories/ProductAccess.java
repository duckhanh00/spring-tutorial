package com.tutorial.Spring.tutorial.repositories;

import com.tutorial.Spring.tutorial.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository("productAccess")
public class ProductAccess implements ProductRepository {
    private static List<Product> DB = new ArrayList<>();

    @Override
    public String insertProduct(UUID id, Product product) {
        Product productObj = new Product(id, product.getProductName(), product.getYear(), product.getPrice(), product.getUrl());
        DB.add(productObj);
        return productObj.toString();
    }

    @Override 
    public List<Product> selectAllProducts() {
        return DB;
    }

    @Override 
    public Optional<Product> selectProductById(UUID productId) {
        return DB.stream()
        .filter(product -> product.getProductId()
        .equals(productId))
        .findFirst();
    }

    @Override
    public int deleteProductById(UUID productId) {
        Optional<Product> product = selectProductById(productId);
        if (product.isEmpty()) {
            return 0;
        }
        DB.remove(product.get());
        return 1;
    };

    @Override
    public int updateProductById(UUID productId, Product newProduct) {
        return selectProductById(productId)
                .map(product -> {
                    int indexOfProductToUpdate = DB.indexOf(product);
                    if (indexOfProductToUpdate >= 0) {
                        Product udpateProduct = new Product(productId, newProduct.getProductName(), newProduct.getYear(), newProduct.getPrice(), newProduct.getUrl());
                        DB.set(indexOfProductToUpdate, udpateProduct);
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    };
}
