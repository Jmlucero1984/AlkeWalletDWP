package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/alkewallet";
    private static final String USER = System.getenv("ALKEWALLET_DB_USER");
    private static final String PASSWORD = System.getenv("ALKEWALLET_DB_PASSWORD");

    public static Connection getConnection() throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}