package com.company.input;

import com.company.users.Customer;
import com.company.users.GeneralUser;
import com.company.users.Shop;
import org.json.simple.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JSONController {
    private final String path = "C:\\Users\\test\\IdeaProjects\\untitled2\\src\\com\\company\\files\\cookies\\cookies.json";
    private final File file = new File(path);
    private JSONObject json = new JSONObject();

    public void addUser(GeneralUser user) throws IOException {
        FileWriter writer = new FileWriter(file);
        json.put("Last visit", getTime());
        if (Customer.class.isInstance(user)){
            addCustomer((Customer) user);
        }
        else {
            addShop((Shop) user);
        }
        writer.write(json.toString());
        writer.close();
    }

    private void addCustomer(Customer customer){
        json.put("class name", "Customer");
        json.put("username", customer.getUsername());
        json.put("name", customer.getFirstName() + ' ' + customer.getLastName());
        json.put("age", customer.getAge());
    }
    private void addShop(Shop shop){
        json.put("class name", "Shop");
        json.put("username", shop.getUsername());
        json.put("name", shop.getName());
        json.put("id", shop.getId());
        json.put("email", shop.getEmail());
        json.put("phone number", shop.getNumber());
        json.put("address", shop.getAddress());
    }

    public String getUserInfo() {
        String str = "";
        try {
            Scanner scanner = new Scanner(file);
            str = beautifulString(scanner.nextLine());

        }
        catch (java.io.FileNotFoundException e){
            System.out.println(e);
        }
        return str;
    }
    private String getTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
    private String beautifulString(String str) {
        str = str.replace("\"", "");
        str = str.replace("{", "");
        str = str.replace("}", "");
        str = str.replace(":", ": ");
        str = str.replace(",", "\n");
        return str;
    }
}
