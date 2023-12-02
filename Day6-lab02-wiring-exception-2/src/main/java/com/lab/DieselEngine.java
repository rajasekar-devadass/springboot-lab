package com.lab;

public class DieselEngine implements IEngine {
    @Override
    public void run() {
        System.out.println(this.getClass().getName() + " running");
    }
}
