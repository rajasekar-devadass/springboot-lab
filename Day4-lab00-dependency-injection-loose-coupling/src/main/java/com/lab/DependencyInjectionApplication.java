package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {

    @Autowired
    public IEngine engine;

//    tight coupling
//    @Autowired
//    public PetrolEngine engine;

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        engine.run();
    }
}
