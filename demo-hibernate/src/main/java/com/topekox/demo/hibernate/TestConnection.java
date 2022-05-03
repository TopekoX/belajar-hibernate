package com.topekox.demo.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/belajar_hibernate";
        String user = "ucup";
        String password = "******";
        
        System.out.println("Connection to " + url);
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successfully");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
