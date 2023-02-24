package com.company.pages;

import com.company.data.interfaces.DataBaseInterface;
import com.company.input.MyScanner;
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
    private final Customer customer;
    private final ProductRepository productDB;
    private final BucketRepository bucketDB;
    private final MyScanner scanner;

    public CustomerPage(Customer customer, DataBaseInterface db){
        this.customer = customer;
        this.productDB = new ProductRepository(db);
        this.bucketDB = new BucketRepository(db);
        this.scanner = new MyScanner(System.in);
    }

    public void render(){
        System.out.printf("Account: %s\nName: %s %s\n\n", customer.getUsername(), customer.getFirstName(), customer.getLastName());
        while(true){
            showBucket();
            showAllProducts();
            addProductToBucket(customer);
        }
    }

    private void showAllProducts(){
        System.out.println("Products on marketplace");
        ArrayList<Product> products = this.productDB.getAllElements();
        for (Product item : products){
            System.out.println(item);
        }
        System.out.println();
    }

    private void showBucket(){
        Bucket bucket = bucketDB.getBucketByCustomer(customer);
        if (bucket.getItems().size() == 0){
            System.out.println("Your bucket is empty\n");
            return ;
        }
        System.out.println("This is your bucket:");
        int count = 1;
        for (BucketItem item : bucket.getItems()) {
            System.out.println(count + ". " + item);
            count++;
        }
        System.out.println();
    }

    private void addProductToBucket(Customer customer){
        System.out.println("You may also add products to your bucket. \nEnter product Id");
        int product_id = scanner.nextInt();
        System.out.println("Enter amount to be added:");
        int amount = scanner.nextInt();
        BucketItem item = new BucketItem(customer, productDB.getElementById(product_id), amount);
        System.out.println("jklhlkj");
        if (bucketDB.isItemInBucket(item, this.customer)){
            System.out.println("Product is already in you bucket\n");
        }
        else {
            System.out.println("khkh");
            bucketDB.addItem(item);
            System.out.println("Product has been successfully added to your bucket. \n");
        }
    }
}
