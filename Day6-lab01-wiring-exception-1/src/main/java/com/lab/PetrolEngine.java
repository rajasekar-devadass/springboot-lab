package com.lab;

import org.springframework.stereotype.Component;

//@Component
public class PetrolEngine {
    public void run() {
        System.out.println(this.getClass().getName() + " running");
    }
}
