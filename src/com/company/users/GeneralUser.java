package com.company.users;
import com.company.users.interfaces.GeneralUserInterface;

public abstract class GeneralUser implements GeneralUserInterface{
    private int id;
    private static int amountOfObjects = 0;
    private String username;
    private String password;
    private String number;
    private String email;

    public GeneralUser(String username, String password, String number, String email){
        this.id = amountOfObjects += 1;
        this.username = username;
        this.password = password;
        this.number = number;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
