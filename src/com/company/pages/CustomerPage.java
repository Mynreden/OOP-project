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

import java.util.Scanner;
import java.util.ArrayList;

public class CustomerPage {
    private Customer customer;
    private ProductRepository productDB;
    private BucketRepository bucketDB;
    private Scanner scanner;

    public CustomerPage(Customer customer, DataBaseInterface db){
        this.customer = customer;
        this.productDB = new ProductRepository(db);
        this.bucketDB = new BucketRepository(db);
        this.scanner = new Scanner(System.in);
    }

    public void render(){
        System.out.println(customer);
        while(true){
            this.showBucket();
            addProductToBucket(customer);
        }
    }

    private void showAllProducts(){
         ArrayList<Product> products = this.productDB.getAllElements();
         for (Product item : products){
             System.out.println(item);
         }

    }

    private void showBucket(){
        System.out.println("This is your bucket:");
        Bucket bucket = bucketDB.getBucketByCustomer(customer);
        int count = 0;
        for (BucketItem item : bucket.getItems()) {
            System.out.println(count + ". " + item);
            count++;
        }
    }

    private void addProductToBucket(Customer customer){
        System.out.println("\nYou may also add products to your bucket. \nEnter product Id");
        int product_id = scanner.nextInt();
        System.out.println("Enter amount to be added:");
        int amount = scanner.nextInt();
        Product product = productDB.getElementById(product_id);
        bucketDB.addItem(new BucketItem(customer, product, amount));
        System.out.println("Product has been successfully added to your bucket. \n");
    }

}
