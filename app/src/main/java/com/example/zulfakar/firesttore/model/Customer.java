package com.example.zulfakar.firesttore.model;

/**
 * Created by zulfakar on 27/07/18.
 * For educational purposes
 */
public class Customer {
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
