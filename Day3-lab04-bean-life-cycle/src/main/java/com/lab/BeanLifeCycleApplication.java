package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifeCycleApplication implements CommandLineRunner {

    @Autowired
    public AccountsController accountsController;

    public static void main(String[] args) {
        SpringApplication.run(BeanLifeCycleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");
    }
}
