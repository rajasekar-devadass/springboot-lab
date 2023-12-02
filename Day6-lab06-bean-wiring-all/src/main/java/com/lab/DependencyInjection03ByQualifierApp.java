package com.lab;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjection03ByQualifierApp implements CommandLineRunner {

/*
    Understand the exceptions
    org.springframework.beans.factory.NoUniqueBeanDefinitionException
    Field engine in com.lab.DependencyInjectionApplication required a single bean, but 2 were found:
    uncomment the qualifier to avoid above exceptions
*/

    /*    Wiring for Interface (By Type) */
    @Resource
//    @Autowired
//    @Inject
    @Qualifier("electricEngine")
    public IEngine engine;


    public static void main(String[] args) {
        SpringApplication.run(DependencyInjection03ByQualifierApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        engine.run();
    }
}
