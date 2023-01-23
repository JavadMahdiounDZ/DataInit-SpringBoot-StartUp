package com.javad;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * by impl the ApplicationRunner and override the run method
 */
@RequiredArgsConstructor
@Component
public class DataLoader_1 implements ApplicationRunner {

    private final CityRepository repository;

    public void run(ApplicationArguments args) {
        initCityData();
    }


    private void initCityData() {

        City tehran = new City().setName("Tehran");
        City florida = new City().setName("Florida");
        City tokyo = new City().setName("Tokyo");

        repository.save(tehran);
        repository.save(florida);
        repository.save(tokyo);
    }
}
