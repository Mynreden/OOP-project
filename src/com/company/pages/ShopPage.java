package com.company.pages;

import com.company.data.interfaces.DataBaseInterface;
import com.company.items.Product;
import com.company.repositories.ProductRepository;
import com.company.users.Customer;
import com.company.users.Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopPage {
    private Shop shop;
    private ProductRepository productDB;

    public ShopPage(Shop shop, DataBaseInterface db) {
        this.shop = shop;
        this.productDB = new ProductRepository(db);
    }

    public void render() {
        while (true){
            this.showAllProducts();
            System.out.print('\n');

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want add some products?");
            String answer = scanner.nextLine();
            if (answer.toLowerCase().equals("yes")){
                productCreationForm();
                System.out.println("\nProduct successfully added");
            }
            else break;
        }
    }

    public void showAllProducts() {
        ArrayList<Product> products = this.productDB.getAllElements();
        for (Product item : products) {
            System.out.println(item);
        }
    }

    private Product productCreationForm(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to add?");
        String name = scan.nextLine();

        System.out.println("Add short description of the product");
        String description = scan.nextLine();

        System.out.println("Write a cost of the product");
        int cost = scan.nextInt();

        Product product = new Product(name, description, this.shop.getId(), cost);
        this.productDB.addElement(product);
        return product;
    }

}