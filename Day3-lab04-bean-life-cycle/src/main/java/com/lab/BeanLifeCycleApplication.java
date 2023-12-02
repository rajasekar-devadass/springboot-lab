package com.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifeCycleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BeanLifeCycleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");
        System.out.println("Only AccountsController bean got created, PaymentsController bean is not created yet");
    }
}
