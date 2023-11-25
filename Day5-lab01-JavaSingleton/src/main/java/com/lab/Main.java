package com.lab;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        SingletonRepository instance1 = SingletonRepository.getInstance();
        SingletonRepository instance2 = SingletonRepository.getInstance();
        if (instance1 == instance2) {
            System.out.println("instances are same");
        } else {
            System.out.println("more than one instance has been created");
        }
        System.out.println("hashcode of instance 1 : " + instance1.hashCode());
        System.out.println("hashcode of instance 2 : " + instance2.hashCode());

    }
}