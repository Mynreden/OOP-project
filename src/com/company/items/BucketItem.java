package com.company.items;

import com.company.users.Customer;

public class BucketItem {
    private Customer customer;
    private Product product;
    private int amount;

    public BucketItem(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Product %s - %s with cost %d and amount of %d pcs.", this.product.getName(), this.product.getDescription(), this.product.getCost(), this.amount);
    }
}
