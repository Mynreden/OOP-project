package com.company.pages;

import com.company.data.interfaces.DataBaseInterface;
import com.company.input.MyScanner;
import com.company.items.Product;
import com.company.repositories.ProductRepository;
import com.company.repositories.ShopRepository;
import com.company.users.Shop;

import java.util.ArrayList;

public class ShopPage {
    private Shop shop;
    private ProductRepository productDB;
    private ShopRepository shopDB;
    private final MyScanner scanner = new MyScanner(System.in);

    public ShopPage(Shop shop, DataBaseInterface db) {
        this.shop = shop;
        this.productDB = new ProductRepository(db);
        this.shopDB = new ShopRepository(db);
    }

    public void render() {
        System.out.printf("Account: %s\nName: %s\n\n", shop.getUsername(), shop.getName());
        while (true) {
            this.showShopProducts();
            addProduct();
        }
    }

    private void showAllProducts() {
        ArrayList<Product> products = this.productDB.getAllElements();
        int count = 1;
        for (Product item : products) {
            System.out.printf("%d. Product %s, Cost: %d\n", count, item.getName(), item.getCost());
            count += 1;
        }
        System.out.println();
    }

    private void showShopProducts() {
        System.out.println("Your products:");
        ArrayList<Product> products = this.shopDB.getShopProducts(shop);
        int count = 1;
        for (Product item : products) {
            System.out.printf("%d. Product %s, Cost: %d\n", count, item.getName(), item.getCost());
            count += 1;
        }
        System.out.println();
    }

    private Product productCreationForm() {
        System.out.println("What do you want to add?");
        String name = scanner.nextLine();

        System.out.println("Add short description of the product");
        String description = scanner.nextLine();

        System.out.println("Write a cost of the product");
        int cost = scanner.nextInt();

        Product product = new Product(name, description, this.shop.getId(), cost);
        this.productDB.addElement(product);
        return product;
    }

    private void addProduct() {
        System.out.println("Do you want add product?");
        String answer = scanner.nextLine();
        if (answer.toLowerCase().equals("yes")) {
            productCreationForm();
            System.out.println("\nProduct successfully added");
        }
    }

    public String userInfo() {
        return "";
    }
}