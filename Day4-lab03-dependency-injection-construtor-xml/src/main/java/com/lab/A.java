package com.lab;

//@Component
public class A {

    private B b;

    //    @Autowired
    public A(B b) {
        this.b = b;
        System.out.println("Default Constructor called for " + this.getClass().getName());
        System.out.println("Value of B " + b);
    }

    //    @PostConstruct
    public void afterCreation() {
        System.out.println("afterCreation called for " + this.getClass().getName());
        System.out.println(toString());
    }

    //    @PreDestroy
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
