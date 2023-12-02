package com.lab;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;

@SpringBootApplication
public class AutowiringDemoApplication implements CommandLineRunner {

    static {
        System.out.println("Resolve the exceptions using @Primary & @qualifier");
    }

    @Autowired
//    @Resource
//    @Inject
//    @Qualifier("dieselEngine")
    public IEngine engine;

    public static void main(String[] args) {
        SpringApplication.run(AutowiringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        engine.run();

    }
}
