package com.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {

    @Bean("duplicate_instance_of_A")
    public A duplicate_instance_of_A(){
        return new A();
    }

}
