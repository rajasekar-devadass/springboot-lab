package com.lab;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjection02ByNameApp implements CommandLineRunner {

/*
    Understand the exceptions
    org.springframework.beans.factory.NoUniqueBeanDefinitionException
    Field engine in com.lab.DependencyInjectionApplication required a single bean, but 2 were found:
    uncomment the qualifier to avoid above exceptions
*/

    /*    Wiring for Interface (By Name) */
    @Resource
//    @Autowired
//    @Inject
    public IEngine petrolEngine;

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjection02ByNameApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        petrolEngine.run();
    }
}
