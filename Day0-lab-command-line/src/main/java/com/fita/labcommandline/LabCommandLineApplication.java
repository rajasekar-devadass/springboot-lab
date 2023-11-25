package com.fita.labcommandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabCommandLineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LabCommandLineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
    }
}
