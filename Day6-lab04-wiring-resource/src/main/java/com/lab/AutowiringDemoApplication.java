package com.lab;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutowiringDemoApplication implements CommandLineRunner {

//    @Resource
//    public IEngine iengine;

    @Resource
    public PetrolEngine engine;

    @Resource
    @Qualifier("dieselEngine")
    public IEngine petrolEngine;

    @Resource
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
