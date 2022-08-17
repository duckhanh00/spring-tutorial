package com.tutorial.Spring.tutorial.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID productId;
    @NotBlank
    private final String productName;
    private final int year;  
    @NotBlank
    private final Double price;
    private final String url;

    public Product(@JsonProperty("productId") UUID productId, 
                    @JsonProperty("productName") String productName, 
                    @JsonProperty("year") int year, 
                    @JsonProperty("price") Double price, 
                    @JsonProperty("url") String url) {
        this.productId = productId;
        this.productName = productName;
        this.year = year;
        this.price = price;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" + 
        "productId=" + productId +
        ", productName='" + productName + "\'" +
        ", year=" + year +
        ", price=" + price +
        ", url='" + url + "\'" + "}";
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}
