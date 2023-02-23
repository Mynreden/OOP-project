package com.company.data;


import com.company.data.interfaces.DataBaseInterface;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PostgresDB implements DataBaseInterface {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "sultan2004");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
