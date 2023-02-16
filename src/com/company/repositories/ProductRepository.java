package com.company.repositories;

import com.company.data.interfaces.DataBaseInterface;
import com.company.products.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository extends GeneralRepository {

    public ProductRepository(DataBaseInterface db){
        super(db);
    }

    public boolean addElement(Product product) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO products(name, description, shop_id, cost)" +
                    "VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, product.getName());
            st.setString(2, product.getDescription());
            st.setInt(3, product.getShopId());
            st.setInt(4, product.getCost());

            st.execute();
            product.setId(getIdFromDB(product));

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

    public Product getElementById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name, description, shop_id, cost FROM products WHERE product_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product product = new Product(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("shop_id"),
                        rs.getInt("cost")
                );
                product.setId(id);
                return product;
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
    public ArrayList<Product> getAllElements(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name, description, shop_id, cost, product_id FROM products";
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()){
                Product product = new Product(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("shop_id"),
                        rs.getInt("cost")
                );
                product.setId(rs.getInt("product_id"));
                list.add(product);
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
    public int getIdFromDB(Product product){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT product_id FROM products WHERE name=? AND description=? AND shop_id=? AND cost=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, product.getName());
            st.setString(2, product.getDescription());
            st.setInt(3, product.getShopId());
            st.setInt(4, product.getCost());


            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return rs.getInt("product_id");
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

}