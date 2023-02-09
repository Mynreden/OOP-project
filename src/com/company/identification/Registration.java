package com.company.identification;

import com.company.repositories.CustomerRepository;

import java.util.Scanner;


public class Registration {
    public static void registration(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Who you are?");
        System.out.println("1. Shop owner" + "\n" + "2. Сustomer ");
        int choice = scan.nextInt();
        if(choice ==1){
            ShopOwnerRegistration();
        }
        if(choice==2){
            СustomerRegistration();
        }
    }
    public static void СustomerRegistration(){
    Scanner scan = new Scanner(System.in);

      System.out.println("Enter your name:");
    String name = scan.nextLine();

      System.out.println("Enter your last name:");
    String lastName = scan.nextLine();

      System.out.println("Enter your age:");
    int age = scan.nextInt();

    password();

        System.out.println("Enter your username:");
    String username = scan.next();
    }

    public static void ShopOwnerRegistration(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the name of your store:");
        String name = scan.nextLine();

        System.out.println("Enter the type of your store:");
        String lastName = scan.nextLine();

        password();

        System.out.println("Enter your username:");
        String username = scan.next();
    }


    public static void password(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a password: (For example: P@ssword161291).");
        String password = scan.next();

        if(password.length() <= 8){
            System.out.println("The password must contain 8 or more characters");
            password();
            return;
        }

        if (!checkForSpecialCharacters(password)) {
            System.out.println("The password must contain at least one special characters (For example: P@ssword 161291). :)");
            password();
            return;
        }

        if(!checkForUppercaseLetter(password)){
            System.out.println("The password must contain at least one uppercase letter. :)");
            password();
            return;
        }

        if(!checkForDigit(password)){
            System.out.println("The password must contain at least one digit . :)");
            password();
            return;
        }

    }
    public static boolean checkForUppercaseLetter(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkForSpecialCharacters(String password) {
        String specialCharacters = "!@#$%^&*()_+-=[]{}|,./<>?;':";
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkForDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
