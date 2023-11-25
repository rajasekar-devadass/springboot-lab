package com.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class AccountsController {

    public AccountsController(){
        System.out.println("Default Constructor called");
    }

    @PostConstruct
    public void afterCreation(){
        System.out.println("afterCreation called");
    }
    @PreDestroy
    public void beforeDeletion(){
        System.out.println("beforeDeletion called");
    }

}
