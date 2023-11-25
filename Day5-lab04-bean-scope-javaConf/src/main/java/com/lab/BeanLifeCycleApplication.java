package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class BeanLifeCycleApplication implements CommandLineRunner {

    @Autowired
    public A instance1_A;
    @Autowired
    public A instance2_A;

    @Autowired
    public B instance1_B;
    @Autowired
    public B instance2_B;

    public static void main(String[] args) {
        SpringApplication.run(BeanLifeCycleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (instance1_A == instance2_A) {
            System.out.println("instances are same");
        } else {
            System.out.println("more than one instance has been created");
        }
        System.out.println("hashcode of instance 1 : " + instance1_A.hashCode());
        System.out.println("hashcode of instance 2 : " + instance2_A.hashCode());

        System.out.println("\n###############################################\n");

        if (instance1_B == instance2_B) {
            System.out.println("instances are same");
        } else {
            System.out.println("more than one instance has been created");
        }
        System.out.println("hashcode of instance 1 : " + instance1_B.hashCode());
        System.out.println("hashcode of instance 2 : " + instance2_B.hashCode());
    }
}
