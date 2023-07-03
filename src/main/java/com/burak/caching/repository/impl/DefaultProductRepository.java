package com.burak.caching.repository.impl;

import com.burak.caching.model.Product;
import com.burak.caching.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultProductRepository implements ProductRepository {

    private static List<Product> products;

    public DefaultProductRepository() {
        products = new ArrayList<>();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> id.equals(p.getId()))
                .findAny();
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

}
