/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import readingnews.entity.User;

/**
 *
 * @author minhnguyen
 */
public class UserModel {

    public void register(User user) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            StringBuilder query = new StringBuilder();
            query.append("Insert into users(username, password, email) value (")
                    .append("\"")
                    .append(user.getUsername()).append("\", \"")
                    .append(user.getPassword()).append("\", \"")
                    .append(user.getEmail()).append("\");");
            System.out.println(query.toString());
            Statement stament = connection.createStatement();
            stament.execute(query.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        if(checkExist(username, password)){
            return true;
        }
        return false;
    }

    public boolean checkExist(String username, String password) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            StringBuilder query = new StringBuilder();
            query.append("Select * From users Where username = \"").append(username)
                    .append("\" AND password = \"").append(password).append("\";");
            System.out.println(query.toString());
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query.toString());
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        User user = new User(3, "Minh4", "21312312", "email@12345", 0);
        UserModel model = new UserModel();
        model.register(user);
    }
}
