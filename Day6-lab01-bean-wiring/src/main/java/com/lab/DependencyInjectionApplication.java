package com.lab;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {


//    org.springframework.beans.factory.NoUniqueBeanDefinitionException
//    Field engine in com.lab.DependencyInjectionApplication required a single bean, but 2 were found:
//     uncomment the qualifier to avoid above exceptions

    @Resource
//    @Autowired
//    @Inject
    @Qualifier("electricEngine")
    public IEngine engine;

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        engine.run();
    }
}
