package com.javad;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * by creating a bean for ApplicationRunner and pass All repositories to our custom initData method
 * Tip: we can pass Repositories or inject them.
 */
//@RequiredArgsConstructor
@Component
public class DataLoader_2 {

//    private final CityRepository cityRepository;

    @Bean
    public ApplicationRunner initData(CityRepository cityRepository) {
        return args -> {
          initCityData(cityRepository);
        };
    }


    private void initCityData(CityRepository cityRepository) {

        City city1 = new City().setName("city1");
        City city2 = new City().setName("city2");
        City city3 = new City().setName("city3");

        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);
    }
}
