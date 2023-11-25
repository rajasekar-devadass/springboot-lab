package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements IEngine{

    @PostConstruct
    public void afterCreation() {
        System.out.println("afterCreation called for " + this.getClass().getName());
    }

    @PreDestroy
    public void beforeDeletion() {
        System.out.println("beforeDeletion called for " + this.getClass().getName());
    }


    @Override
    public void run() {
        System.out.println("petrol engine running");
    }
}
