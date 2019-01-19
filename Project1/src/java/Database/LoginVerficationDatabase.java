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
public class LoginVerficationDatabase  extends DatabaseConnector{
    public void checkData(String email, String password){
        System.out.println("email2:-"+email+"  "+password);
        initializeDbConnection();
        String name=null,pass=null;
        try {
            resultSet=smt.executeQuery("SELECT * FROM Login WHERE username='"+email+"'" );
            while(resultSet.next()){
                name=resultSet.getString("username");
                pass=resultSet.getString("passwords");
            }
            if(pass.equals(password)){
                    System.out.println("yo are welcome");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            closeDbConnection(connection);
        }
    }
}
