package com.burak.caching.service.impl;

import com.burak.caching.model.Product;
import com.burak.caching.repository.ProductRepository;
import com.burak.caching.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

}
