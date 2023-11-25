package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class B {

    @PostConstruct
    public void afterCreation() {
        System.out.println("afterCreation called for " + this.getClass().getName());
    }

    @PreDestroy
    public void beforeDeletion() {
        System.out.println("beforeDeletion called for " + this.getClass().getName());
    }

    @Override
    public String toString() {
        return "B{}";
    }
}
