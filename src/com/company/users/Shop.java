package com.company.users;

import java.util.ArrayList;

import com.company.items.Product;

public class Shop extends GeneralUser {
    private String name;
    private String address;
    private int id;

    public Shop(String username, String password, String name, String address, String number, String email) {
        super(username, password, number, email);
        this.name = name;
        this.address = address;
        this.id = -1;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return String.format("%d. Shop %s with email %s", this.id, this.name, this.getEmail());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
