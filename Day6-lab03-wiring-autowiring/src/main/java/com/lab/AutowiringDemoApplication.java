package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutowiringDemoApplication implements CommandLineRunner {

//    @Autowired
//    public IEngine iengine;

    @Autowired
    public PetrolEngine engine;

    @Autowired
    @Qualifier("dieselEngine")
    public IEngine petrolEngine;

    @Autowired
    public IEngine dieselEngine;

    public static void main(String[] args) {
        SpringApplication.run(AutowiringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        engine.run();
        petrolEngine.run();
        dieselEngine.run();
    }
}
