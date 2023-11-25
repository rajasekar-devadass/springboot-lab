package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class B {

    @PostConstruct
    public void afterCreation() {
        System.out.println("afterCreation called for " + this.getClass().getName());
    }

    @PreDestroy
    public void beforeDeletion() {
        System.out.println("beforeDeletion called for " + this.getClass().getName());
    }

}
