package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentsController {

    public PaymentsController() {
        System.out.println("Default Constructor called - " + this.getClass().getName());
    }

    @PostConstruct
    public void afterCreation() {
        System.out.println("afterCreation called - " + this.getClass().getName());
    }

    @PreDestroy
    public void beforeDeletion() {
        System.out.println("beforeDeletion called - " + this.getClass().getName());
    }

}
