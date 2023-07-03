package com.burak.caching.listener;

import com.burak.caching.model.Product;
import com.burak.caching.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    private final ProductRepository productRepository;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        productRepository.save(
                Product.builder()
                        .id(1L)
                        .name("Iphone")
                        .price(new BigDecimal(100L))
                        .build()
        );
    }

}
