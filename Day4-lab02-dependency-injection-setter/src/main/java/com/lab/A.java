package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    private B b;

    public A() {
        System.out.println("Default constructor called for " + this.getClass().getName());
    }

    @Autowired
    public void setB(B b) {
        this.b = b;
        System.out.println("setter method called for " + this.getClass().getName());
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
