package com.company.products;

import com.company.products.interfaces.ProductInterface;
import com.company.users.Shop;

public class Product implements ProductInterface{
    private int id;
    private static int amountOfObjects = 0;
    private String name;
    private String description;
    private Shop shop;

    public Product(String name, String description, Shop shop){
        this.id = amountOfObjects += 1;
        this.description = description;
        this.name = name;
        this.shop = shop;
        shop.addProduct(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Shop getShop() {
        return shop;
    }

    @Override
    public String toString(){
        return String.format("Product: %s", this.name);
    }
}
