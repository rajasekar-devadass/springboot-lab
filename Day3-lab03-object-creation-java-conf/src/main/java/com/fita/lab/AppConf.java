package com.fita.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
    public BookController a() {
        return new BookController(30);
    }

    @Bean
    public StudentController b() {
        return new StudentController(3);
    }
}
