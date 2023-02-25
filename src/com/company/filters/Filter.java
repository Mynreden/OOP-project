package com.company.filters;

import com.company.data.interfaces.DataBaseInterface;
import com.company.items.Product;
import com.company.repositories.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filter {
    private final DataBaseInterface db;
    private final ProductRepository productDB;

    public Filter(DataBaseInterface db) {
        this.db = db;
        this.productDB = new ProductRepository(db);
    }

    public ArrayList<Product> filterByPrice(double minPrice, double maxPrice) {
        Connection con = null;
        try {
            con = db.getConnection();

            // create SQL statement with parameters
            String sql = "SELECT * FROM products WHERE cost BETWEEN ? AND ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, minPrice);
            pstmt.setDouble(2, maxPrice);

            // execute query and process results
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("shop_id"),
                        rs.getInt("cost")
                );
                product.setId(rs.getInt("product_id"));
                products.add(product);
            }
            return products;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void filterByСategory() {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "161291_Era")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose category: ");
            showAllСategory();
            String category = scanner.next();
            String sql = "SELECT * FROM products WHERE type = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("product_id") + " .Product " + rs.getString("name") + " - " + rs.getString("description") + " with cost " + rs.getDouble("cost"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showAllСategory() {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "161291_Era")) {

            // create SQL statement
            String sql = "SELECT type FROM products";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // execute query and process results
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void filterByСategoryAndCost() {


        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "161291_Era")) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter minimum price: ");
            double minPrice = scan.nextDouble();
            System.out.print("Enter maximum price: ");
            double maxPrice = scan.nextDouble();
            System.out.println("Choose category: ");
            showAllСategory();
            String category = scan.next();
            String sql = "SELECT * FROM products WHERE cost BETWEEN ? AND ? AND type = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, minPrice);
            pstmt.setDouble(2, maxPrice);
            pstmt.setString(3, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("product_id") + " .Product " + rs.getString("name") + " - " + rs.getString("description") + " with cost " + rs.getDouble("cost"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

