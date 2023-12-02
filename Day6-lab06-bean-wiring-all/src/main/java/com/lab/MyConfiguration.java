package com.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {


    @Bean
    public PetrolEngine petrolEngine() {
        return new PetrolEngine();
    }

    @Bean
    public ElectricEngine electricEngine() {
        return new ElectricEngine();
    }

}
