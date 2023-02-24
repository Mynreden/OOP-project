package com.company.input.commands;

import com.company.input.JSONController;
import com.company.input.commands.interfaces.CommandsInterface;
import com.sun.tools.javac.Main;
import com.company.start.StartProgram;
import java.util.Scanner;

public class SpecialCommands implements CommandsInterface {
    Scanner scanner;
    public SpecialCommands(){
        this.scanner = new Scanner(System.in);
    }
    public void help(){
        System.out.println("Available commands: help\n\tlogout\n\tinfo");
        String command = scanner.next();
        switch (command) {
            case "help" -> this.help();
            case "logout" -> this.logout();
            case "back" -> {
                return ;
            }
            case "info" -> this.userInfo();

        }
    }
    public void logout(){
        StartProgram.start();
    }
    public void back(){
        return ;
    }
    public void userInfo(){
        JSONController json = new JSONController();
        System.out.println(json.getUserInfo());
    }
}
