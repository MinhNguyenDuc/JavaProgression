/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author nguye
 */
public class UserModel {
    
    /**
     * Dùng để đăng kí tài khoản
     */
    public boolean register(User user){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO users (id, username, password, email, createdTime) VALUES (");
            sb.append(user.getId()).append(", ")
              .append(user.getUsername()).append(", ")
              .append(user.getPassword()).append(", ")
              .append(user.getEmail()).append(", ")
              .append(user.getCreatedTime()).append(")");
            System.out.println(sb.toString());
            Statement stm = connection.createStatement();
            stm.execute(sb.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean checkExist(User user){
        return false;
    }
    
    public User login(String username, String password){
        return new User();
    }
    
    
}
