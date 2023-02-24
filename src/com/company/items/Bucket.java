package com.company.items;

import java.util.ArrayList;
import java.util.Iterator;

public class Bucket {
    private int customer_id;
    private ArrayList<BucketItem> items;

    public Bucket(int customer_id) {
        this.customer_id = customer_id;
        this.items = new ArrayList<>();
    }

    public int getCustomerId() {
        return this.customer_id;
    }

    public ArrayList<BucketItem> getItems() {
        return this.items;
    }

    public void addItem(BucketItem item) {
        this.items.add(item);
    }

}
