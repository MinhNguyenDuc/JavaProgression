/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingnews;

import java.sql.SQLException;
import readingnews.entity.User;
import readingnews.model.UserModel;

/**
 *
 * @author xuanhung
 */
public class ReadingNews {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserModel userModel = new UserModel();    
        User user = new User("phuonganh", "phuonganh@gmail.com", "1234567");
        try {
            userModel.register(user);
            System.out.println("Lưu thành công.");
        } catch (SQLException e) {
            System.err.println("Không thể lưu thông tin.");
        }
        
    }
    
}
