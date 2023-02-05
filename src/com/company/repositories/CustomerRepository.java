package com.company.repositories;

import com.company.data.interfaces.DataBaseInterface;

import com.company.data.interfaces.DataBaseInterface;
import com.company.users.Customer;
import com.company.users.interfaces.GeneralUserInterface;
import java.sql.*;

public class CustomerRepository {
    private final DataBaseInterface db;

    public CustomerRepository(DataBaseInterface db){
        this.db = db;
    }

    public boolean createCustomer(Customer customer) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO customers(username, password, first_name, last_name,  phone_number, email, age) " +
                    "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, customer.getUsername());
            st.setString(2, customer.getPassword());
            st.setString(3, customer.getFirstName());
            st.setString(4, customer.getLastName());
            st.setString(5, customer.getNumber());
            st.setString(6, customer.getEmail());
            st.setInt(7, customer.getAge());

            st.execute();
            System.out.printf("Added customer %s to database successfully", customer);
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

}
