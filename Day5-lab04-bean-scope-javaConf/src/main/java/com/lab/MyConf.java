package com.lab;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConf {

    @Bean
//    @Scope(value="singleton")
    public A createInstanceOfA() {
        return new A();
    }

    @Bean
    @Scope(value="prototype")
    public B createInstanceOfB() {
        return new B();
    }

}
