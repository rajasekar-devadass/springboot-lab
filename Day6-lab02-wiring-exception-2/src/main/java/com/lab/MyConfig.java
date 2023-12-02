package com.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {

    @Bean
    public DieselEngine dieselEngine() {
        return new DieselEngine();
    }

    @Bean
//    @Primary
    public PetrolEngine petrolEngine() {
        return new PetrolEngine();
    }
}
