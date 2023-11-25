package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    private B b;

    @Autowired
    public A(B b) {
        this.b = b;
    }

    @PostConstruct
    public void afterCreation() {
        System.out.println("afterCreation called for " + this.getClass().getName());
        System.out.println(toString());
    }

    @PreDestroy
    public void beforeDeletion() {
        System.out.println("beforeDeletion called for " + this.getClass().getName());
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
