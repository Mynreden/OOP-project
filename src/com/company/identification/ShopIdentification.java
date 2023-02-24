package com.company.identification;

import com.company.identification.interfaces.Login;
import com.company.identification.interfaces.Registration;
import com.company.input.JSONController;
import com.company.input.MyScanner;
import com.company.repositories.ShopRepository;
import com.company.users.Shop;

import java.util.Scanner;

public class ShopIdentification implements Login, Registration{
    private ShopRepository shopDB;

    public ShopIdentification(ShopRepository shopDB){
        this.shopDB = shopDB;
    }

    public Shop identification(){
        MyScanner in = new MyScanner(System.in);
        System.out.println("1. Create account\n2. Sign in");
        int choice = in.nextInt();
        Shop shop;
        if (choice == 1){
            shop = registration();
        }
        else if (choice == 2) shop = login();
        else {
            System.out.println("Incorrect input");
            return identification();
        }
        JSONController json = new JSONController();
        try {json.addUser(shop);}
        catch (java.io.IOException e){ System.out.println(e);};
        return shop;

    }

    private Shop registration(){
        MyScanner scan = new MyScanner(System.in);

        System.out.println("Enter the name of your store:");
        String name = scan.nextLine();

        System.out.println("Enter the address of your store:");
        String address = scan.nextLine();

        System.out.println("Enter contact phone number:");
        String number = scan.next();

        System.out.println("Enter contact email:");
        String email = scan.next();

        String password1 = Registration.password();

        System.out.println("Enter your username:");
        String username = scan.next();
        Shop shop = new Shop(username, password1, name, address, number, email);
        this.shopDB.addElement(shop);
        return shop;
    }

    private Shop login(){
        MyScanner scan = new MyScanner(System.in);
        System.out.println("Enter your username:");
        String username = scan.next();
        System.out.println("Enter a password:");
        String password = scan.next();
        boolean isCorrect = shopDB.isAccountExist(username, password);
        if (!isCorrect){
            System.out.println("Try again. Password or Username is incorrect");
            return login();
        }
        return shopDB.login(username, password);
    }
}
