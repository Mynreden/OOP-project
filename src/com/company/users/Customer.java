package com.company.users;

public class Customer extends GeneralUser {
    private String firstName;
    private String lastName;
    private int age;
    private int id;

    public Customer(String username, String password, String firstName, String lastName, String number, String email, int age) {
        super(username, password, number, email);
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = -1;
    }

    public Customer(String username, String password) {
        super(username, password, "", "");
        this.age = 0;
        this.firstName = "";
        this.lastName = "";
    }


    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%d. Customer %s with email %s", this.id, this.firstName, this.getEmail());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
