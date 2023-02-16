package com.company.pages;

import com.company.data.interfaces.DataBaseInterface;
import com.company.products.Product;
import com.company.repositories.CustomerRepository;
import com.company.repositories.ProductRepository;
import com.company.users.Customer;

import java.util.ArrayList;

public class CustomerPage {
    private Customer customer;
    private ProductRepository productDB;

    public CustomerPage(Customer customer, DataBaseInterface db){
        this.customer = customer;
        this.productDB = new ProductRepository(db);
    }

    public void render(){
        this.showAllProducts();
    }

    public void showAllProducts(){
         ArrayList<Product> products = this.productDB.getAllElements();
         for (Product item : products){
             System.out.println(item);
         }
    }

}
