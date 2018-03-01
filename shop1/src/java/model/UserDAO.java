/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author 8470p
 */
public class UserDAO {
ConnectDB con=new ConnectDB();
    public UserDAO() {
    }
    public static ArrayList<User> listUser=new ArrayList<>();
    public void adddUser(User us){
    listUser.add(us);}
    public boolean checklogin(String id, String pass){
        try {
            Connection cons=con.getConnect();
            Statement st=cons.createStatement();
            
           
            ResultSet rs=st.executeQuery("select * from user where username='"+id+"' and pass='"+pass+"'");
            while (rs.next()) {
                if (rs.getString(3).equalsIgnoreCase("admin")) {
                    con.getConnect().close();
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    public static void main(String[] args) {
        UserDAO u=new UserDAO();
        u.checklogin("admin", "admin");
        System.out.println(u.checklogin("no", "admin"));
    }
}
