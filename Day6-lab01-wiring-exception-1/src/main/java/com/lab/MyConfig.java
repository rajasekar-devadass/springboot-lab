package com.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

//    @Bean
    public PetrolEngine petrolEngine() {
        return new PetrolEngine();
    }
}
