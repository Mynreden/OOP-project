package com.company.users;


public abstract class GeneralUser {
    private String username;
    private String password;
    private String number;
    private String email;

    public GeneralUser(String username, String password, String number, String email) {
        this.username = username;
        this.password = password;
        this.number = number;
        this.email = email;
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
