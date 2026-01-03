package com.example.PetrolPump.service;

import com.example.PetrolPump.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();

}
