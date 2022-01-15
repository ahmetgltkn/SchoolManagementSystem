package com.example.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourcesConfiguration {

    @Bean(name = "h2Datasource")
    public DataSource h2Datasource(){
        DataSourceBuilder dataSourceBuilder  = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:userdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("1234");
        return dataSourceBuilder.build();
    }
}
