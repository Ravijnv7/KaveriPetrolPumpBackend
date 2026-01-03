package com.example.PetrolPump.service.Impl;

import com.example.PetrolPump.entity.Product;
import com.example.PetrolPump.repository.ProductRepository;
import com.example.PetrolPump.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {

        // 🔒 place for future validation
        // e.g. price > 0, name unique, etc.

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

