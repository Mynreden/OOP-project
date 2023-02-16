package com.company.identification;

import com.company.identification.interfaces.Login;
import com.company.identification.interfaces.Registration;
import com.company.repositories.CustomerRepository;
import com.company.users.Customer;

import java.util.Scanner;

public class CustomerIdentification implements Login, Registration {
    private CustomerRepository customerDB;

    public CustomerIdentification(CustomerRepository customerDB) {
        this.customerDB = customerDB;
    }

    public Customer identification() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Create account\n2. Sign in");
        int choice = in.nextInt();

        if (choice == 1) {
            return registration();
        } else if (choice == 2) return login();
        else {
            System.out.println("Incorrect input");
            return identification();
        }

    }

    private Customer registration() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scan.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scan.nextLine();

        System.out.println("Enter your phone number:");
        String number = scan.next();

        System.out.println("Enter your age:");
        int age = scan.nextInt();

        System.out.println("Enter your email:");
        String email = scan.next();

        String password1 = Registration.password();

        System.out.println("Enter your username:");
        String username = scan.next();
        Customer customer = new Customer(username, password1, name, lastName, number, email, age);
        customerDB.addElement(customer);
        return customer;
    }

    private Customer login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scan.next();
        System.out.println("Enter a password:");
        String password = scan.next();
        boolean isCorrect = customerDB.isAccountExist(username, password);
        if (!isCorrect) {
            System.out.println("Try again. Password or Username is incorrect");
            return login();
        }
        return customerDB.login(username, password);
    }
}