package com.lab;

public class PetrolEngine implements IEngine {
    @Override
    public void run() {
        System.out.println(this.getClass().getName() + " running");
    }
}
