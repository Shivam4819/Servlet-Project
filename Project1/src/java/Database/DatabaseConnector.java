/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author shivam
 */
public class DatabaseConnector {
    protected static final String dbClassName = "com.mysql.jdbc.Driver";
    protected static final String CONNECTION = "jdbc:mysql://127.0.0.1/Project";
    protected Connection connection = null;
    protected Statement smt = null;
    protected ResultSet resultSet = null;

    protected void initializeDbConnection() {

        try {
            Class.forName(dbClassName);
            Properties p = new Properties();
            p.put("user", "root");
            p.put("password", "");
            connection = DriverManager.getConnection(CONNECTION, p);
            smt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not istalled" + e);
        } catch (SQLException e) {
            System.out.println("Not connected to mysql" + e);
        } catch (Exception e) {
            System.out.println("some other exection");
        }
    }

    protected void closeDbConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connection can not be ade free: " + e);
            }
        }
    }
}
