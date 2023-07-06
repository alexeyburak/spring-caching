package com.burak.caching.service.impl;

import com.burak.caching.model.Product;
import com.burak.caching.repository.ProductRepository;
import com.burak.caching.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultProductService implements ProductService {

    private static final String PRODUCTS_CACHE = "products";
    private final ProductRepository productRepository;

    @Cacheable(value = PRODUCTS_CACHE)
    @Override
    public List<Product> findAll() {
        simulateSlowService();

        log.info("Find all products");
        return productRepository.findAll();
    }

    @Cacheable(value = PRODUCTS_CACHE, key = "#id")
    @Override
    public Product findById(Long id) {
        simulateSlowService();

        log.info("Find product by id {}", id);
        return productRepository.findById(id)
                .orElseThrow();
    }

    @CachePut(value = PRODUCTS_CACHE)
    @Override
    public Product save(Product product) {
        productRepository.save(product);

        log.info("Save product");
        return product;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
