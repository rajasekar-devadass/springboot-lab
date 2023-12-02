package com.lab;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutowiringDemoApplication implements CommandLineRunner {


    /*Try this example with both @autowired and @resource and understand the precedence*/

//    @Autowired
    @Resource
    public A a;

    public static void main(String[] args) {
        SpringApplication.run(AutowiringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        a.run();
    }
}
