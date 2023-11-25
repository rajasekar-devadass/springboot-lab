package com.lab;

//@Component
public class AccountsController {

    public AccountsController() {
        System.out.println("Default Constructor called");
    }

    //    @PostConstruct
    public void afterCreation() {
        System.out.println("afterCreation called");
    }

    //    @PreDestroy
    public void beforeDeletion() {
        System.out.println("beforeDeletion called");
    }

}
