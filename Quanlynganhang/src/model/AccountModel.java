/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
/**
 *
 * @author nguye
 */
public class AccountModel {
    public static boolean checklogIn(Account logInAccount) {
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynganhang?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM account WHERE username = '"+logInAccount.getUsername()+"' AND password = '"+logInAccount.getPassword()+"'");
            if(rs.next()){
                return true;
            }
         
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return false;
    }
    
    public static boolean checkSignUp(Account signUpAccount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        
        String createdDate = mYear + "-"+mMonth+"-"+mDay;
        
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynganhang?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM account WHERE username = '"+signUpAccount.getUsername()+"'");
            if(rs.next()){
                return false;
            }
            stm.execute(
                    "INSERT INTO account (accNumber, username, password, createdDate, status) "
                            + "VALUES ('AC"+Math.abs(signUpAccount.getUsername().hashCode())+"', "
                            + "'"+signUpAccount.getUsername()+"', "
                            + "'"+signUpAccount.getPassword()+"',"
                            + "'"+createdDate+"', '1')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();     
        }
        return false;
    }
    
    public int getBalanceInfo(Account a){
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynganhang?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT balance FROM account WHERE username = '"+a.getUsername()+"'");
            rs.next();
            return rs.getInt("balance");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static boolean checkWithDrawAvailable(Account a, int amountofWithDraw){
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynganhang?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT balance FROM account WHERE username = '"+a.getUsername()+"'");
            rs.next();
            int balance = rs.getInt("balance");
            if(balance == 0){
                return false;
            }
            else {
                if(balance < amountofWithDraw){
                    return false;
                }
                withDrawing(a,rs.getInt("balance"), amountofWithDraw);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void withDrawing(Account a, int balance, int amount){
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynganhang?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            stm.execute("UPDATE account SET balance = "+(balance - amount)+" WHERE username = '"+a.getUsername()+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendMoney(Account a, int sendAmount){
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynganhang?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            stm.execute("UPDATE account SET balance = balance + "+sendAmount+" WHERE username = '"+a.getUsername()+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
       AccountModel am = new AccountModel();
       Account a = new Account("Hieu", "1");
       sendMoney(a, 25);
    }
}
