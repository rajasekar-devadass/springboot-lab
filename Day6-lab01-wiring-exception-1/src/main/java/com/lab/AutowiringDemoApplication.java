package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutowiringDemoApplication implements CommandLineRunner {

/*
        System.out.println("Resolve the exceptions using @Primary & @qualifier");
*/

    @Autowired
//    @Resource
//    @Inject
    public PetrolEngine petrolEngine;

    public static void main(String[] args) {
        SpringApplication.run(AutowiringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        petrolEngine.run();

    }
}
