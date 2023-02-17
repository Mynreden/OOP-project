package com.company.repositories;

import com.company.data.interfaces.DataBaseInterface;
import com.company.items.Bucket;
import com.company.items.BucketItem;
import com.company.repositories.ProductRepository;
import com.company.repositories.CustomerRepository;
import com.company.users.Customer;

import java.sql.*;
import java.util.ArrayList;

public class BucketRepository extends GeneralRepository {

    private ProductRepository productDB;
    private CustomerRepository customerDB;

    public BucketRepository(DataBaseInterface db){
        super((db));
        productDB = new ProductRepository(db);
        customerDB = new CustomerRepository(db);
    }

    public boolean addItem(BucketItem item) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO customer_product(customer_id, product_id, amount) " +
                    "VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, item.getCustomer().getId());
            st.setInt(2, item.getProduct().getId());
            st.setInt(7, item.getAmount());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public Bucket getBucketByCustomer(Customer customer) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM customer_product WHERE customer_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, customer.getId());

            ResultSet rs = st.executeQuery();
            Bucket bucket = new Bucket(customer.getId());
            while (rs.next()){
                BucketItem item = new BucketItem(
                        customerDB.getElementById(rs.getInt("customer_id")),
                        productDB.getElementById(rs.getInt("product_id")),
                        rs.getInt("amount")
                );
                bucket.addItem(item);
            }
            return bucket;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    

    

}
