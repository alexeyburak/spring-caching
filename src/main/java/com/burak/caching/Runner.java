package com.burak.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

}
