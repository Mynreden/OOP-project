package com.company.products;

import com.company.products.interfaces.ProductInterface;
import com.company.users.Shop;

public class Product implements ProductInterface{
    private int id;
    private String name;
    private String description;
    private int shopId;
    private int cost;

    public Product(String name, String description, int shop_id, int cost){
        this.id = -1;
        this.description = description;
        this.name = name;
        this.shopId = shop_id;
        this.cost = cost;
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

    public int getShopId(){
        return shopId;
    }

    @Override
    public String toString(){
        return String.format("%d. Product %s - %s", this.id, this.name, this.description);
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
