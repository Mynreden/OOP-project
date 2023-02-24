package com.company.filters;
import com.company.repositories.GeneralRepository;

import java.sql.*;
import java.util.Scanner;
import com.company.data.PostgresDB;
import com.company.data.interfaces.DataBaseInterface;

public class Filter {

    public static void filterByPrice(){
        try(Connection con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/postgres", "postgres", "161291_Era")) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        // create SQL statement with parameters
        String sql = "SELECT * FROM products WHERE cost BETWEEN ? AND ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setDouble(1, minPrice);
        pstmt.setDouble(2, maxPrice);

        // execute query and process results
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("product_id") + " .Product " + rs.getString("name") + " _ " + rs.getString("description") + "with cost " + rs.getDouble("cost"));
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void filterByСategory(){
        try(Connection con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/postgres", "postgres", "161291_Era")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose category: ");
            showAllСategory();
            String category = scanner.next();
            String sql = "SELECT * FROM products WHERE type = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("product_id") + " .Product " + rs.getString("name") + " - " + rs.getString("description") + " with cost " + rs.getDouble("cost"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void showAllСategory(){
       try (Connection conn = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/postgres", "postgres", "161291_Era")) {

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
    public static void filterByСategoryAndCost(){


       try (Connection conn = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/postgres", "postgres", "161291_Era")) {
           Scanner scan = new Scanner(System.in);
           System.out.print("Enter minimum price: ");
           double minPrice = scan.nextDouble();
           System.out.print("Enter maximum price: ");
           double maxPrice = scan.nextDouble();
           System.out.println("Choose category: ");
           showAllСategory();
           String category = scan.next();
           String sql = "SELECT * FROM products WHERE cost BETWEEN ? AND ? AND type = ?" ;
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setDouble(1, minPrice);
           pstmt.setDouble(2, maxPrice);
           pstmt.setString(3,category);
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()) {
               System.out.println(rs.getInt("product_id") + " .Product " + rs.getString("name") + " - " + rs.getString("description") + " with cost " + rs.getDouble("cost"));
           }
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }

}

