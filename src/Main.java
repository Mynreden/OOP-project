import com.company.data.PostgresDB;
import com.company.data.interfaces.DataBaseInterface;
import com.company.identification.CustomerIdentification;
import com.company.identification.ShopIdentification;
import com.company.pages.CustomerPage;
import com.company.pages.ShopPage;
import com.company.repositories.CustomerRepository;
import com.company.repositories.ShopRepository;
import com.company.users.Customer;
import com.company.users.Shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBaseInterface db = new PostgresDB();
        ShopRepository shopDB = new ShopRepository(db);
        CustomerRepository customerDB = new CustomerRepository(db);
        Scanner in = new Scanner(System.in);
        System.out.println("Who you are?\n1. Shop owner\n2. Customer");
        int choice = in.nextInt();
        Customer customer = null;
        Shop shop = null;
        boolean typeOfUser = false; // true for shop, false for customer
        if (choice == 1) {
            ShopIdentification shopId = new ShopIdentification(shopDB);
            shop = shopId.identification();
            typeOfUser = true;

        }
        else if (choice  == 2) {
            CustomerIdentification customerId = new CustomerIdentification(customerDB);
            customer = customerId.identification();

        }
        if (!typeOfUser){
            CustomerPage page = new CustomerPage(customer, db);
            page.render();
        }
        else{
            ShopPage page = new ShopPage(shop, db);
            page.render();
        }
    }
}
