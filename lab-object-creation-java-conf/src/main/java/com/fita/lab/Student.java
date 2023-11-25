package com.fita.lab;

public class Student {
    private int rollNo;
    private String name;
    private Address address;

    public Student(int rollNo, String name, Address address) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
