package com.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public A b() {
        return new A();
    }

    @Bean
    public B a() {
        return new B();
    }
}
