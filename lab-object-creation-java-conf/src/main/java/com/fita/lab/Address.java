package com.fita.lab;

public class Address {
    private String city;
    private String zip;

//    public Address() {
//    }

//    public int Address(){
//        //This is a method and not a constructor
//        return 0;
//    }

    public Address(String city, String zip) {
        this.city = city;
        this.zip = zip;
    }

    public Address(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
