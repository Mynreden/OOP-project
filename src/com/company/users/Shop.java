package com.company.users;

import com.company.products.Product;
import java.util.ArrayList;

public class Shop extends GeneralUser {
    private String name;
    private String address;
    private ArrayList<Product> products;

    public Shop(String username, String password, String name, String address, String number, String email) {
        super(username, password, number, email);
        this.name = name;
        this.address = address;
        this.products = new ArrayList<>();
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

    public Product createProduct(String name, String description){
        return new Product(name, description, this);
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    @Override
    public String toString(){
        return String.format("Shop %s with products %s", this.name, this.products);
    }
}
