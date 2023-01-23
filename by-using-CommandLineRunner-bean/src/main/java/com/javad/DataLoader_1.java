package com.javad;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * by impl the CommandLineRunner and override the run method
 */
@RequiredArgsConstructor
@Component
public class DataLoader_1 implements CommandLineRunner{

    private final ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        initProductData();
    }

    private void initProductData() {
        Product p11 = new Product().setName("p-11");
        Product p12 = new Product().setName("p-12");
        Product p13 = new Product().setName("p-13");
        Product p14 = new Product().setName("p-14");
        Product p15 = new Product().setName("p-15");

        repository.save(p11);
        repository.save(p12);
        repository.save(p13);
        repository.save(p14);
        repository.save(p15);
    }
}
