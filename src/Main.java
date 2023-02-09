import com.company.data.PostgresDB;
import com.company.data.interfaces.DataBaseInterface;
import com.company.products.Product;
import com.company.repositories.ProductRepository;
import com.company.repositories.ShopRepository;

import com.company.users.Customer;
import com.company.users.Shop;

public class Main {
    public static void main(String[] args) {
        Customer Sultan = new Customer("m", "s", "s", "a", "1", "@", 1);
        Shop magnum = new Shop("magnum123", "magmag", "magnum", "Uly dala 7", "+7773332019", "magnum@mag.kz");
        DataBaseInterface db = new PostgresDB();
        ShopRepository ShopDB = new ShopRepository(db);
        Product rice = new Product("rice", "zhana white rice", ShopDB.getIdFromDB(magnum), 600);
        ProductRepository DB = new ProductRepository(db);
        DB.addElement(rice);
        System.out.println(DB.getAllElements());
        System.out.println(DB.getElementById(1));
    }
}
