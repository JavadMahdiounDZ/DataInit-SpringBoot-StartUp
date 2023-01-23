package com.javad;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * by creating a bean for CommandLineRunner and pass All repositories to our custom initData method
 * Tip: we can pass Repositories or inject them.
 */
//@RequiredArgsConstructor
@Component
public class DataLoader_2 {

//    private final ProductRepository productRepository;

    @Bean
    public CommandLineRunner initData(ProductRepository productRepository) {
        return (args) -> {
            initProductData(productRepository);
        };
    }

    private void initProductData(ProductRepository productRepository) {
        Product p1 = new Product().setName("p-1");
        Product p2 = new Product().setName("p-2");
        Product p3 = new Product().setName("p-3");
        Product p4 = new Product().setName("p-4");
        Product p5 = new Product().setName("p-5");

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);
    }
}
