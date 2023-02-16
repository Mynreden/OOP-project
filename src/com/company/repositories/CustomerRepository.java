package com.company.repositories;

import com.company.data.interfaces.DataBaseInterface;
import com.company.users.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository extends GeneralRepository {

    public CustomerRepository(DataBaseInterface db){
        super((db));
    }

    public boolean addElement(Customer customer) {
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

    public Customer getElementById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT username, password, first_name, last_name,  phone_number, email, age FROM customers WHERE customer_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer user = new Customer(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getInt("age")
                        );
                user.setId(id);
                return user;
            }
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
    public ArrayList<Customer> getAllElements(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT username, password, first_name, last_name,  phone_number, email, age, customer_id FROM customers";
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            ArrayList<Customer> list = new ArrayList<>();
            while (rs.next()){
                Customer a = new Customer(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getInt("age")
                );
                a.setId(rs.getInt("customer_id"));
                list.add(a);
            }
            return list;

        }
        catch (SQLException throwables) {
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

    public int getIdFromDB(Customer customer){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT customer_id FROM customers WHERE username=? AND email=? AND first_name=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, customer.getUsername());
            st.setString(2, customer.getEmail());
            st.setString(3, customer.getFirstName());

            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return rs.getInt("customer_id");
            }
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
        return -1;
    }

    public boolean isAccountExist(String username, String password){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT password FROM customers WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return password.equals(rs.getString("password"));
            }
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

    public Customer login(String username, String password){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT customer_id, first_name, last_name,  phone_number, email, age FROM customers WHERE username=? AND password=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer user = new Customer(username, password,
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getInt("age")
                );
                user.setId(rs.getInt("customer_id"));
                return user;
            }
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
        return  null;
    }

}
