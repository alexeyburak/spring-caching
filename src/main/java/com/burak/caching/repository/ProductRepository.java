package com.burak.caching.repository;

import com.burak.caching.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save(Product product);
}
