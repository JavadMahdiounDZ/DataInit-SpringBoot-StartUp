package com.javad;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader {

    private final Environment environment;


    @Bean(name = "dataSource")
    public DataSource dataSource1() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name")); // or hardcoded "org.h2.Driver"
        dataSource.setUrl(environment.getProperty("spring.datasource.url")); // or hardcoded the url
        dataSource.setUrl(";
//        dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");
        dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");


        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setUsername("sa");


        dataSource.setPassword(environment.getProperty("jdbc.pass"));
        dataSource.setPassword("");


        // schema init
        Resource initSchema = new ClassPathResource("scripts/schema-h2.sql");
        Resource initData = new ClassPathResource("scripts/data-h2.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        return dataSource;
    }
}
