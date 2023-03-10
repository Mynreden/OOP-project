package com.company.input;

import com.company.input.commands.SpecialCommands;

import java.io.InputStream;
import java.util.Scanner;

public class MyScanner {
    private Scanner scanner;
    private SpecialCommands com = new SpecialCommands();

    public MyScanner(InputStream IS) {
        this.scanner = new Scanner(IS);
    }

    public String next() {
        String a = scanner.next();
        if (a.equals("help")) {
            com.help();
            a = scanner.next();
        } else if (a.equals("logout")) {
            com.logout();
        }
        return a;
    }

    public String nextLine() {
        String a = scanner.nextLine();
        if (a.equals("help")) {
            com.help();
            a = scanner.next();
        }
        return a;
    }

    public int nextInt() {
        try {
            String a = scanner.next();
            if (a.equals("help")) {
                com.help();
                a = scanner.next();
            }
            return Integer.parseInt(a);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Write Integer numbers");
            return nextInt();
        }
    }

    public double nextDouble() {
        try {
            String a = scanner.next();
            if (a.equals("help")) {
                com.help();
                a = scanner.next();
            }
            return Double.parseDouble(a);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Write numbers, not string");
            return nextDouble();
        }
    }

}
