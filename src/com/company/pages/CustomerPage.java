package com.company.pages;

import com.company.data.interfaces.DataBaseInterface;
import com.company.items.BucketItem;
import com.company.items.Product;
import com.company.repositories.BucketRepository;
import com.company.repositories.CustomerRepository;
import com.company.repositories.ProductRepository;
import com.company.users.Customer;
import com.company.items.Bucket;
import com.company.items.BucketItem;

import java.util.ArrayList;

public class CustomerPage {
    private Customer customer;
    private ProductRepository productDB;
    private BucketRepository bucketDB;

    public CustomerPage(Customer customer, DataBaseInterface db){
        this.customer = customer;
        this.productDB = new ProductRepository(db);
        this.bucketDB = new BucketRepository(db);
    }

    public void render(){
        this.showBucket();
    }

    public void showAllProducts(){
         ArrayList<Product> products = this.productDB.getAllElements();
         for (Product item : products){
             System.out.println(item);
         }
    }

    public void showBucket(){
        Bucket bucket = bucketDB.getBucketByCustomer(customer);
        int count = 0;
        for (BucketItem item : bucket.getItems()) {
            System.out.println(count + ". " + item);
            count++;
        }

    }

}
