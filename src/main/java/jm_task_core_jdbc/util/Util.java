package jm_task_core_jdbc.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;

public class Util {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/users";;
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private static final Logger logger = Logger.getLogger(Util.class.getName());

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.info("Driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Connection error");
        }
        return connection;
    }



}
