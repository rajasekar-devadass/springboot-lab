package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class A {

    public void afterCreation() {
        System.out.println("afterCreation called for " + this.getClass().getName());
    }

    public void beforeDeletion() {
        System.out.println("beforeDeletion called for " + this.getClass().getName());
    }

}
