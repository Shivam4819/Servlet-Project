/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shivam
 */
public class RegistrationDatabase extends DatabaseConnector{
    public void insertData(String email, String password){
        System.out.println("email:-"+email+"  "+password);
        initializeDbConnection();
        try {
            smt.executeUpdate("INSERT INTO Login (username,passwords) VALUES ('"+email+"','"+password+"')" );
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            closeDbConnection(connection);
        }
    }
}
