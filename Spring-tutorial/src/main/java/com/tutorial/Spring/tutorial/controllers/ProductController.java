package com.tutorial.Spring.tutorial.controllers;

import com.tutorial.Spring.tutorial.models.Product;
import com.tutorial.Spring.tutorial.services.ProductService;

import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@Valid @NotNull @RequestBody Product product) {
        productService.addProduct(product);
    }
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path="{productId}")
    public Product getProductById(@PathVariable("productId") UUID productId) {
        return productService.getProductById(productId)
            .orElse(null);
    }

    @DeleteMapping(path="{productId}")
    public void deleteProductById(@PathVariable("productId") UUID productId) {
        productService.deleteProductById(productId);
    }

    @PutMapping(path="{productId}")
    public void updateProductById(@PathVariable("productId") UUID productId, @Valid @NotNull @RequestBody Product newProduct) {
        productService.updateProductById(productId, newProduct);
    }
}
