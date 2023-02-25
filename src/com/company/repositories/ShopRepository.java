package com.company.repositories;

import com.company.data.interfaces.DataBaseInterface;
import com.company.items.Product;
import com.company.users.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShopRepository extends GeneralRepository {

    public ShopRepository(DataBaseInterface db) {
        super(db);
    }

    public boolean addElement(Shop shop) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO shops(username, password, name, phone_number, address, email)" +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, shop.getUsername());
            st.setString(2, shop.getPassword());
            st.setString(3, shop.getName());
            st.setString(4, shop.getNumber());
            st.setString(5, shop.getAddress());
            st.setString(6, shop.getEmail());

            st.execute();
            shop.setId(getIdFromDB(shop));

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

    public Shop getElementById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT username, password, name, phone_number, address, email FROM shops WHERE shop_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Shop shop = new Shop(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("email"));
                shop.setId(id);
                return shop;
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

    public ArrayList<Shop> getAllElements() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT username, password, name, phone_number, address, email, shop_id FROM shops";
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            ArrayList<Shop> list = new ArrayList<>();
            while (rs.next()) {
                Shop a = new Shop(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("email"));
                a.setId(rs.getInt("shop_id"));
                list.add(a);
            }
            return list;

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

    public int getIdFromDB(Shop shop) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT shop_id FROM shops WHERE username=? AND email=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, shop.getUsername());
            st.setString(2, shop.getEmail());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("shop_id");
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

    public boolean isAccountExist(String username, String password) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT password FROM shops WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return password.equals(rs.getString("password"));
            }
        } catch (SQLException throwables) {
            return false;
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

    public Shop login(String username, String password) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  shop_id, name, phone_number, address, email FROM shops WHERE password=? AND username=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, password);
            st.setString(2, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Shop shop = new Shop(username,
                        password,
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("email"));
                shop.setId(rs.getInt("shop_id"));
                return shop;
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

    public ArrayList<Product> getShopProducts(Shop shop) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name, description, shop_id, cost, product_id FROM products WHERE shop_id=?";
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, shop.getId());
            ResultSet rs = pr.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
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
