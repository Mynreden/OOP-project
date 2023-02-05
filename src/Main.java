import com.company.data.PostgresDB;
import com.company.data.interfaces.DataBaseInterface;
import com.company.products.Product;
import com.company.repositories.CustomerRepository;
import com.company.users.Customer;
import com.company.users.GeneralUser;
import com.company.users.Shop;
import com.company.users.interfaces.GeneralUserInterface;

import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Customer Sultan = new Customer("m", "s", "s", "a", "1", "@", 1);
        System.out.println(Sultan);
        Shop magnum = new Shop("m", "s", "m", "u", "7", "3");

        System.out.println(magnum.createProduct("ris", "krutoi"));
        Product ris = new Product("sahar", "kr", magnum);
        System.out.println(magnum);
        GeneralUserInterface m = new Customer("sd", "fds", "sfd", "df", "f", " ds", 10);
        DataBaseInterface db = new PostgresDB();
        CustomerRepository S = new CustomerRepository(db);
        S.createCustomer(Sultan);
    }

}
