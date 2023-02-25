package com.company.identification.interfaces;

import com.company.input.MyScanner;

import java.util.Scanner;

public interface Registration {
    public static String password() {
        MyScanner scan = new MyScanner(System.in);
        System.out.println("Enter a password: (For example: P@ssword161291).");
        String password1 = scan.next();

        if (password1.length() < 8) {
            System.out.println("The password must contain 8 or more characters");
            return password();
        }

        if (!checkForSpecialCharacters(password1)) {
            System.out.println("The password must contain at least one special characters (For example: P@ssword 161291). :)");
            return password();
        }

        if (!checkForUppercaseLetter(password1)) {
            System.out.println("The password must contain at least one uppercase letter. :)");
            return password();
        }

        if (!checkForDigit(password1)) {
            System.out.println("The password must contain at least one digit . :)");
            return password();
        }
        return password1;

    }

    public static boolean checkForUppercaseLetter(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
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
