package com.fita.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
    public BookController createBookController() {
        return new BookController(30);
    }

    @Bean
    public StudentController createStudentController() {
        return new StudentController(3);
    }
}
