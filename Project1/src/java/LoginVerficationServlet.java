/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.LoginVerficationDatabase;
/**
 *
 * @author shivam
 */
public class LoginVerficationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        int flag;
        System.out.println("email2->"+email);
        LoginVerficationDatabase loginDatabase=new LoginVerficationDatabase();
        flag=loginDatabase.checkData(email, password);
        if(flag==1){
            response.sendRedirect("DataDisplay.jsp");
        }
        
    }

    
}
