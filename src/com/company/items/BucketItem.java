package com.company.items;

public class BucketItem{
    private int customer_id;
    private int product_id;
    private int amount;

    public BucketItem(int customer_id, int product_id, int amount){
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.amount = amount;
    }

    public int getCustomerId() {
        return this.customer_id;
    }

    public int getProductId() {
        return this.product_id;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
