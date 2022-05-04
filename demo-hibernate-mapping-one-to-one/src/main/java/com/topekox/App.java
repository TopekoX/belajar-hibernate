package com.topekox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/belajar_hibernate";
        String user = "ucup";
        String password = "******";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi Berhasil");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
