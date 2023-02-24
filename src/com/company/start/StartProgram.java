package com.company.start;

import com.company.data.PostgresDB;
import com.company.data.interfaces.DataBaseInterface;
import com.company.identification.*;
import com.company.input.MyScanner;
import com.company.pages.*;
import com.company.repositories.*;
import com.company.users.*;

public class StartProgram {
    public static void start(){
        DataBaseInterface db = new PostgresDB();
        ShopRepository shopDB = new ShopRepository(db);
        CustomerRepository customerDB = new CustomerRepository(db);
        MyScanner in = new MyScanner(System.in);
        System.out.println("Who you are?\n1. Shop owner\n2. Customer");
        int choice = in.nextInt();
        if (choice == 1) {
            shopProgram(shopDB, db);
        }
        else if (choice  == 2) {
            customerProgram(customerDB, db);
        }
    }

    private static void shopProgram(ShopRepository shopDB, DataBaseInterface db){
        ShopIdentification shopId = new ShopIdentification(shopDB); // identification
        Shop shop = shopId.identification();

        ShopPage page = new ShopPage(shop, db); // rendering page
        page.render();
    }

    private static void customerProgram(CustomerRepository customerDB, DataBaseInterface db){
        CustomerIdentification customerId = new CustomerIdentification(customerDB); // identification
        Customer customer = customerId.identification();

        CustomerPage page = new CustomerPage(customer, db); // rendering page
        page.render();
    }
}
